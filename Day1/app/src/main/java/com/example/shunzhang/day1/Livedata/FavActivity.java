package com.example.shunzhang.day1.Livedata;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.View;

import com.example.shunzhang.day1.Livedata.Room.FavBean;
import com.example.shunzhang.day1.Livedata.Room.FavDao;
import com.example.shunzhang.day1.Livedata.Room.FavDatabase;
import com.example.shunzhang.day1.RandomQuote.RandomQuoteActivity;

import java.util.List;

/**
 * Created by shunzhang on 05/06/2018.
 */

public class FavActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        FavDao favDao = FavDatabase.getInstance(this).fav();
        favDao.getFav().observe(this, new Observer<List<FavBean>>() {
            @Override
            public void onChanged(@Nullable List<FavBean> favBeans) {
                System.out.println("LiveData update");
                System.out.println(favBeans);
            }

        });
    }

    public void update(View view) {
        System.out.println("LiveData update");
    }

    public static Intent getCallingIntent(Context context){
        Intent callingIntent = new Intent(context, FavActivity.class);
        return callingIntent;
    }
}
