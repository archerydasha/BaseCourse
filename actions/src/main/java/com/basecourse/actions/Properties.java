package com.basecourse.actions;

/**
 * Created by dshcherbyna on 28.02.14.
 */
public class Properties {

    private final FIMEventType eventType;

    public Properties(FIMEventType eventType){
        this.eventType = eventType;
    }

    public FIMEventType getEventType() {
        return eventType;
    }
}
