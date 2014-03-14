package com.basecourse.actions;

import com.google.common.base.Splitter;
import com.google.common.collect.Iterables;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Created by dshcherbyna on 28.02.14.
 */
public class Properties {

    private final EventType eventType;

    private final String feedFileName;

    private static Log LOG = LogFactory.getLog(Properties.class);

    public Properties(String params){
        String[] paramsArray = Iterables.toArray(Splitter.on(',').trimResults().split(params), String.class);
        String eventType = getParamValue(paramsArray[0]);
        String fileName = getParamValue(paramsArray[1]);
        LOG.info("Properties are: " + eventType + ", " + fileName);
        this.eventType = EventType.valueOf(eventType);
        this.feedFileName = fileName;
    }

    private String getParamValue(String  parameter) {
        return Iterables.toArray(Splitter.on('=').trimResults().split(parameter), String.class)[1];
    }

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
