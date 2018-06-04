package com.example.shunzhang.day1.Dagger;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.example.shunzhang.day1.RandomQuote.RandomQuoteActivity;

import javax.inject.Inject;

/**
 * Created by shunzhang on 04/06/2018.
 */

public class DaggerActivity2 extends AppCompatActivity {
    @Inject
    DaggerBean daggerBean;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DaggerComponent daggerComponent = DaggerDaggerComponent.create();
        daggerComponent.inject(this);

        Log.d("==================", daggerBean.getHello());
    }


    public static Intent getCallingIntent(Context context){
        Intent callingIntent = new Intent(context, DaggerActivity2.class);
        return callingIntent;
    }
}
