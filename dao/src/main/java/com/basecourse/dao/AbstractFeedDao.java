package com.basecourse.dao;

import com.basecourse.model.*;

/**
 * Created by dshcherbyna on 06.03.14.
 */
public interface AbstractFeedDao {

    void saveFeedInstance(FeedInstance instance);

    FeedInstance getFeedInstance();

    void saveFeedInstanceTechParameters(FeedInstanceTechParams parameters);

    FeedInstanceTechParams getFeedInstanceTechParameters();
}
