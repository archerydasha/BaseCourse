package com.basecourse.actions;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class StartPoint {

    public static void main(String[] args) {
        Frontend frontend = new Frontend();
        frontend.processAction("eventType=FEED_EVENT, fileName=FIM_FIM-FR_0877_76833-1_57_20140527_20140120070615_20140311.zip");
    }
}