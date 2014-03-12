package com.basecourse.actions;

import org.apache.commons.logging.Log;
/**
 * Created by dshcherbyna on 26.02.14.
 */
public abstract class Action {
    protected EventType eventType;

    abstract void processEvent(Properties properties);

    public EventType getEventType() {
        return eventType;
    }
}
