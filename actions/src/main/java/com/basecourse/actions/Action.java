package com.basecourse.actions;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public abstract class Action {
    protected EventType eventType;
 //   protected FIMService service;

    abstract void yield();

    abstract void processEvent(Properties properties);

    EventType getEventType() {
        return eventType;
    }
}
