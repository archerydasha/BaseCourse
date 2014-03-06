package com.basecourse.services;

import com.basecourse.dao.AbstractFakeDao;
import com.google.inject.Inject;

/**
 * Created by dshcherbyna on 06.03.14.
 */
public class FakeManagement implements FakeService {
    private AbstractFakeDao dao;
    @Inject
    public FakeManagement(AbstractFakeDao dao){
        this.dao = dao;
        System.out.println("com.basecourse.services.FakeManagement was instantiated with Guice");
    }
}
