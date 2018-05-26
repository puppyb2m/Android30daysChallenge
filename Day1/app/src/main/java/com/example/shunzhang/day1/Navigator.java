package com.example.shunzhang.day1;

import android.content.Context;
import android.content.Intent;

public enum Navigator {

    INSTANCE;

    public void navigateToAddTask(Context context){
        if(context != null){
            Intent callingIntent = AddTaskActivity.getCallingIntent(context);
            context.startActivity(callingIntent);
        }
    }
}
