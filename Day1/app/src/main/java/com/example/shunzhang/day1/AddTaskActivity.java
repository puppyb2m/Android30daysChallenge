package com.example.shunzhang.day1;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;

public class AddTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.add_task);
    }

    public static Intent getCallingIntent(Context context){
        Intent callingIntent = new Intent(context, AddTaskActivity.class);
        return callingIntent;
    }
}

