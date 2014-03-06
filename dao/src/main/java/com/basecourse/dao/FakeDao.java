package com.basecourse.dao;

/**
 * Created by dshcherbyna on 06.03.14.
 */
public class FakeDao implements AbstractFakeDao {
    public FakeDao(){
        System.out.println("com.basecourse.dao.FakeDao was instantiated with Guice");
    }
}
