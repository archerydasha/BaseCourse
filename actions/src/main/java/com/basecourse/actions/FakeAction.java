package com.basecourse.actions;

import com.basecourse.services.FakeService;
import com.google.inject.Inject;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class FakeAction extends Action {
    private FakeService service;

    @Inject
    public FakeAction(FakeService service) {
        this.service = service;
        eventType = EventType.FAKE_EVENT;
        System.out.println("com.basecourse.actions.FakeAction was instantiated with Guice");
    }

    public void yield() {
        System.out.println("com.basecourse.actions.FakeAction was instantiated with Guice");
    }

    @Override
    void processEvent(Properties properties) {
        //just a dummy here
    }
}
