package com.basecourse.actions;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class Frontend {
    private Injector injector;
    private Set<Action> actions;

    public Frontend() {
        injector = DI.getInjector();
        actions = injector.getInstance(Key.get(new TypeLiteral<Set<Action>>() {
        }));
    }

    public void processAction(String params) {
        String[] paramsArray = Iterables.toArray(Splitter.on(',').trimResults().split(params), String.class);
        String eventName = paramsArray[0];
        String fileName = paramsArray[1];
        Properties properties = new Properties(EventType.valueOf(eventName), fileName);
        processAction(properties);
    }

    private void processAction(Properties properties) {
        Action action = findNeededAction(properties.getEventType());
        action.processEvent(properties);
    }

    private Action findNeededAction(EventType eventType) {
        for (Action action : actions) {
            if (action.getEventType() == eventType) {
                return action;
            }
        }
        return null;
    }
}
