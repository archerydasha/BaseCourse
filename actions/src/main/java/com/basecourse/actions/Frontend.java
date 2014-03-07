package com.basecourse.actions;

import com.google.common.base.Predicate;
import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class Frontend {
    private Set<Action> actions;

    public Frontend() {
        Injector injector = DI.getInjector();
        actions = injector.getInstance(Key.get(new TypeLiteral<Set<Action>>() {
        }));
    }

    public void processAction(String params) {
        String[] paramsArray = Iterables.toArray(Splitter.on(',').trimResults().split(params), String.class);
        String eventType = getParamValue(paramsArray[0]);
        String fileName = getParamValue(paramsArray[1]);
        Properties properties = new Properties(EventType.valueOf(eventType), fileName);
        processAction(properties);
    }

    private void processAction(Properties properties) {
        Action action = findNeededAction(properties.getEventType());
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
