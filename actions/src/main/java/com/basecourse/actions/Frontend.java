package com.basecourse.actions;

import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import javax.annotation.Nullable;
import java.util.Set;
import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class Frontend {
    private Set<Action> actions;
    private Logger LOG = Logger.getLogger(Frontend.class);

    public Frontend() {
        Injector injector = DI.getInjector();
        actions = injector.getInstance(Key.get(new TypeLiteral<Set<Action>>() {
        }));
       PropertyConfigurator.configure(Frontend.class.getResourceAsStream("/com/basecourse/actions/log4j.properties"));
    }

    public void processAction(String params) {
        LOG.info("Frontend.processAction function called with parameter " + params);
        String[] paramsArray = Iterables.toArray(Splitter.on(',').trimResults().split(params), String.class);
        String eventType = getParamValue(paramsArray[0]);
        String fileName = getParamValue(paramsArray[1]);
        LOG.info("Properties are: " + eventType + ", " + fileName);
        Properties properties = new Properties(EventType.valueOf(eventType), fileName);
        processAction(properties);
    }

    private void processAction(Properties properties) {
        Action action = findNeededAction(properties.getEventType());
        LOG.info("Action to be used is: " + action.getClass());
        action.processEvent(properties);
    }

    private Action findNeededAction(final EventType eventType) {
        Predicate<Action> p = new Predicate<Action>() {
            @Override
            public boolean apply(@Nullable Action a) {
                return (a.getEventType() == eventType);
            }
        };
        return Iterables.find(actions, p);
    }

    private String getParamValue(String parameter) {
        return Iterables.toArray(Splitter.on('=').trimResults().split(parameter), String.class)[1];
    }
}
