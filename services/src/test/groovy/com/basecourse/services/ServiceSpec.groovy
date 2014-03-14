package com.basecourse.services

import com.basecourse.dao.AbstractFeedDao
import com.basecourse.dao.FeedDao
import com.basecourse.model.FeedInstance
import com.basecourse.model.FeedInstanceTechParams
import spock.lang.Specification

/**
 * Created by dshcherbyna on 14.03.14.
 */
class ServiceSpec extends Specification{
    def "DAO saving methods should be called"(){
        setup:
        def dao = Mock(AbstractFeedDao);
        def service = new FeedManagement(dao);
        def instance = new FeedInstance("FeedFileName");
        def techParams = new FeedInstanceTechParams("FeedCheckSum");
        when: service.createFeed("FeedFileName","FeedCheckSum");
        then:
        1* dao.saveFeedInstance(instance);
        1* dao.saveFeedInstanceTechParameters(techParams);
    }

}
