package com.basecourse.actions;

import com.google.inject.Inject;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class FakeAction extends Action {

    @Inject
    public FakeAction() {
        eventType = EventType.FAKE_EVENT;
//        this.service = service;
    }

    public void yield() {
        System.out.println("com.basecourse.actions.FakeAction was instantiated");
    }

    @Override
    void processEvent(Properties properties) {
        //just a dummy here
    }
}
