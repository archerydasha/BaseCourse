package com.basecourse.actions;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class StartPoint {

    public static void main(String[] args) {

        //ToDo - parse String parameter to com.basecourse.actions.Properties using guava

        //Properties properties1 = new Properties(EventType.FAKE_EVENT);
        //frontend.processAction(properties1);
        //FIM_FIM-FR_0877_76833-1_57_20140527_20140120070615

        Properties properties2 = new Properties(EventType.FEED_EVENT, "FIM_FIM-FR_0877_76833-1_57_20140527_20140120070615.zip");
        Frontend frontend = new Frontend();

        frontend.processAction(properties2);
    }
}