package com.basecourse.actions;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public abstract class Action {
    protected FIMEventType eventType;
 //   protected FIMService service;

    abstract void yield();

    FIMEventType getEventType() {
        return eventType;
    }
}
