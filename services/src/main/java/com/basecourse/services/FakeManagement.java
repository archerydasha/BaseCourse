package com.basecourse.services;

import com.basecourse.dao.AbstractFakeDao;
import com.google.inject.Inject;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by dshcherbyna on 06.03.14.
 */
public class FakeManagement implements FakeService {
    private AbstractFakeDao dao;
    private static Log LOG = LogFactory.getLog(FakeManagement.class);

    @Inject
    public FakeManagement(AbstractFakeDao dao) {
        this.dao = dao;
        LOG.info("FakeManagement was instantiated with Guice");
    }
}
