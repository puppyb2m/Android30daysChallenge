package com.example.shunzhang.day1.Livedata;

import android.arch.lifecycle.Observer;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.text.Layout;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.example.shunzhang.day1.Livedata.Room.FavBean;
import com.example.shunzhang.day1.Livedata.Room.FavDao;
import com.example.shunzhang.day1.Livedata.Room.FavDatabase;
import com.example.shunzhang.day1.R;
import com.example.shunzhang.day1.RandomQuote.RandomQuoteActivity;
import com.example.shunzhang.day1.RandomQuote.RandomQuoteContract;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by shunzhang on 05/06/2018.
 */

public class FavActivity extends AppCompatActivity {

    private FavDao favDao;

    @BindView(R.id.fav_button)
    Button button;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.fav_main);

        favDao = FavDatabase.getInstance(this).fav();
        favDao.getFav().observe(this, new Observer<List<FavBean>>() {
            @Override
            public void onChanged(@Nullable List<FavBean> favBeans) {
                System.out.println("LiveData update end");
                System.out.println(favBeans);
            }

        });

        ButterKnife.bind(this);
    }

    @OnClick(R.id.fav_button)
    public void onBtnClick(View view){
        System.out.println("LiveData update start");
        updateData();
    }

    private void updateData(){
        FavBean favBean = new FavBean(0,"this is title");
        favDao.insertNewMessage(favBean);
    }


    public static Intent getCallingIntent(Context context){
        Intent callingIntent = new Intent(context, FavActivity.class);
        return callingIntent;
    }
}
