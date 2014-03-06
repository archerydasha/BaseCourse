package com.basecourse.services;

import com.basecourse.model.FeedInstance;
import com.basecourse.model.FeedInstanceTechParams;
import com.google.inject.Inject;
import com.basecourse.dao.*;

/**
 * Created by dshcherbyna on 26.02.14.
 */
public class FeedManagement implements FeedService {
    private AbstractFeedDao dao;

    @Inject
    public FeedManagement(AbstractFeedDao dao){
        this.dao = dao;
        System.out.println("com.basecourse.services.FeedManagement was instantiated with Guice");
    }

    @Override
    public void createFeed(String filename, String containerType) {
        FeedInstance instance = new FeedInstance(filename);
        FeedInstanceTechParams params = new FeedInstanceTechParams(containerType);//create FeedInstance
        dao.saveFeedInstance(instance);
        dao.saveFeedInstanceTechParameters(params);
    }

}
