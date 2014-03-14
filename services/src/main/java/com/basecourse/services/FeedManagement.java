package com.basecourse.services;

import com.basecourse.model.FeedInstance;
import com.basecourse.model.FeedInstanceTechParams;
import com.google.inject.Inject;
import com.basecourse.dao.*;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;


/**
 * Created by dshcherbyna on 26.02.14.
 */
public class FeedManagement implements FeedService {
    private AbstractFeedDao dao;
    private static Log LOG = LogFactory.getLog(FeedManagement.class);

    @Inject
    public FeedManagement(AbstractFeedDao dao){
        this.dao = dao;
        LOG.info("FeedManagement was instantiated with Guice");
    }

    @Override
    public void createFeed(String filename, String checksum) {
        LOG.info("Creating FeedInstance and FeedInstanceTechParams");
        FeedInstance instance = new FeedInstance(filename);
        FeedInstanceTechParams params = new FeedInstanceTechParams(checksum);
        LOG.info("Saving FeedInstance and FeedInstanceTechParams");
        dao.saveFeedInstance(instance);
        dao.saveFeedInstanceTechParameters(params);
    }

}
