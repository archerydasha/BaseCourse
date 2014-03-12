package com.basecourse.dao;

import com.basecourse.model.FeedInstance;
import com.basecourse.model.FeedInstanceTechParams;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Created by dshcherbyna on 06.03.14.
 */
public class FeedDao implements AbstractFeedDao {
    private static Log LOG = LogFactory.getLog(FeedDao.class);

    public FeedDao() {
       LOG.info("FeedDao was instantiated with Guice");
    }

    @Override
    public void saveFeedInstance(FeedInstance instance) {
        LOG.info("saveFeedInstance called");
        System.out.println("FeedInstance for file " + instance.getFileName() + " was saved");
    }

    @Override
    public FeedInstance getFeedInstance() {
        LOG.info("getFeedInstance called");
        return new FeedInstance("dummy.zip");
    }

    @Override
    public void saveFeedInstanceTechParameters(FeedInstanceTechParams parameters) {
        LOG.info("saveFeedInstanceTechParameters called");
       System.out.println("FeedInstanceTechParams " + parameters.getContainerType() + " were saved");
    }

    @Override
    public FeedInstanceTechParams getFeedInstanceTechParameters() {
        LOG.info("getFeedInstanceTechParameters called");
        return new FeedInstanceTechParams("dummy");
    }
}
