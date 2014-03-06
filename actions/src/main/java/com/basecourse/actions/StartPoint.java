package com.basecourse.actions;

import com.google.common.base.Splitter;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class StartPoint {

    public static void main(String[] args) {

        //ToDo - parse String parameter to com.basecourse.actions.Properties using guava
        //Iterable<String> strings = Splitter.on(',').trimResults().split("wer, ytr, jj");


        Properties properties = new Properties(EventType.FEED_EVENT, "FIM_FIM-FR_0877_76833-1_57_20140527_20140120070615.zip");
        Frontend frontend = new Frontend();

        frontend.processAction(properties);
    }
}