package com.example.shunzhang.day1.Dagger;

import dagger.Component;
import dagger.Module;
import dagger.Provides;

/**
 * Created by shunzhang on 01/06/2018.
 */


@Module
public class DaggerModel {

    @Provides
    static DaggerBean providesDaggerBean(){
        return new DaggerBean("hello dagger");
    }
}
