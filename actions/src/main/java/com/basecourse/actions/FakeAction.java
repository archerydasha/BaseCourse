package com.basecourse.actions;

import com.basecourse.services.FakeService;
import com.google.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class FakeAction extends Action {
    private FakeService service;
    private static Log LOG = LogFactory.getLog(FakeAction.class);

    @Inject
    public FakeAction(FakeService service) {
        this.service = service;
        eventType = EventType.FAKE_EVENT;
        LOG.info("FakeAction was instantiated with Guice");
    }

    @Override
    void processEvent(Properties properties) {
        //just a dummy here
    }
}
