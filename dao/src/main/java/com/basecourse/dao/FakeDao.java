package com.basecourse.dao;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

/**
 * Created by dshcherbyna on 06.03.14.
 */
public class FakeDao implements AbstractFakeDao {
    private static Log LOG = LogFactory.getLog(FakeDao.class);
    public FakeDao(){
        LOG.info("FakeDao was instantiated with Guice");
    }
}
