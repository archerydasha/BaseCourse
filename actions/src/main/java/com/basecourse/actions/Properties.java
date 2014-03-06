package com.basecourse.actions;

/**
 * Created by dshcherbyna on 28.02.14.
 */
public class Properties {

    private final EventType eventType;

    private final String feedFileName;

    public Properties(EventType eventType, String feedFileName) {
        this.eventType = eventType;
        this.feedFileName = feedFileName;
    }

    public EventType getEventType() {
        return eventType;
    }

    public String getFeedFileName() {
        return feedFileName;
    }

}
