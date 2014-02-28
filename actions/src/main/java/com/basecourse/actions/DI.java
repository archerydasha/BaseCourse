package com.basecourse.actions;


import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Created by dshcherbyna on 28.02.14.
 */
public class DI {
    private static Injector injector;

    private DI() {
    }

    public static Injector getInjector() {
        if (injector == null) {
            injector = Guice.createInjector(new ActionModule());
        }
        return injector;
    }

}
