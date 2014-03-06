package com.basecourse.dao;

import com.basecourse.model.FeedInstance;
import com.basecourse.model.FeedInstanceTechParams;

/**
 * Created by dshcherbyna on 06.03.14.
 */
public class FeedDao implements AbstractFeedDao {

    public FeedDao() {
        System.out.println("com.basecourse.dao.FeedDao was instantiated with Guice");
    }

    @Override
    public void saveFeedInstance(FeedInstance instance) {
        System.out.println("FeedInstance for file " + instance.getFileName() + " was saved");
    }

    @Override
    public FeedInstance getFeedInstance() {
        return new FeedInstance("dummy.zip");
    }

    @Override
    public void saveFeedInstanceTechParameters(FeedInstanceTechParams parameters) {
       System.out.println("FeedInstanceTechParams " + parameters.getContainerType() + " were saved");
    }

    @Override
    public FeedInstanceTechParams getFeedInstanceTechParameters() {
        return new FeedInstanceTechParams("dummy");
    }
}
