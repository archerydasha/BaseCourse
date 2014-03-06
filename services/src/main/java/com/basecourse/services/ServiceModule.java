package com.basecourse.services;

import com.basecourse.dao.AbstractFakeDao;
import com.basecourse.dao.AbstractFeedDao;
import com.basecourse.dao.FakeDao;
import com.basecourse.dao.FeedDao;
import com.google.inject.AbstractModule;

/**
 * Created by dshcherbyna on 06.03.14.
 */
public class ServiceModule extends AbstractModule {
    @Override
    protected void configure() {
        bind(AbstractFeedDao.class).to(FeedDao.class);
        bind(AbstractFakeDao.class).to(FakeDao.class);
    }
}
