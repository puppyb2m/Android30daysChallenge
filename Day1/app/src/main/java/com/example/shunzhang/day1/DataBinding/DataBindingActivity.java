package com.example.shunzhang.day1.DataBinding;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v7.app.AppCompatActivity;
import android.databinding.DataBindingUtil;

import com.example.shunzhang.day1.AddTaskActivity;
import com.example.shunzhang.day1.R;
import com.example.shunzhang.day1.databinding.DatabindingActivityBinding;

public class DataBindingActivity extends AppCompatActivity {

    private DataBindingUserModel userModel;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        DatabindingActivityBinding activityBinding = DataBindingUtil.setContentView(this, R.layout.databinding_activity);

        userModel = new DataBindingUserModel("Chris","cc@gamil.com");

        activityBinding.setUser(userModel);
    }

    public static Intent getCallingIntent(Context context){
        Intent callingIntent = new Intent(context, DataBindingActivity.class);
        return callingIntent;
    }
}
