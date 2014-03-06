package com.basecourse.actions;

import com.google.inject.Injector;
import com.google.inject.Key;
import com.google.inject.TypeLiteral;

import java.util.Set;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class Frontend {
    private Injector injector;
    private Set<Action> actions;

    public Frontend(){
        injector = DI.getInjector();
        actions = injector.getInstance(Key.get(new TypeLiteral<Set<Action>>() {
        }));
    }

    public void processAction(Properties properties) {
        Action action = findNeededAction(properties.getEventType());
        action.yield();
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
