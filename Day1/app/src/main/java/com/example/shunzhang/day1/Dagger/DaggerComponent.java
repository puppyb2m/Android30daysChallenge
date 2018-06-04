package com.example.shunzhang.day1.Dagger;

import dagger.Component;

@Component(modules = DaggerModel.class)
public interface DaggerComponent{

    void inject(DaggerActivity2 activity);
}
