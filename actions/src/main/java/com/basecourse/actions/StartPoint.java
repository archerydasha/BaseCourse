package com.basecourse.actions;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class StartPoint {

    public static void main(String[] args) {

        //ToDo - parse String parameter to com.basecourse.actions.Properties using guava

        Properties properties1 = new Properties(FIMEventType.JSONEVENT);
        Properties properties2 = new Properties(FIMEventType.XMLEVENT);

        Frontend frontend = new Frontend();

        frontend.processAction(properties1);
        frontend.processAction(properties2);
    }

}
