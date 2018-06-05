package com.example.shunzhang.day1;

import android.content.Context;
import android.content.Intent;

import com.example.shunzhang.day1.Livedata.FavActivity;
import com.example.shunzhang.day1.RandomQuote.RandomQuoteActivity;

public enum Navigator {

    INSTANCE;

    public void navigateToAddTask(Context context){
        if(context != null){
            Intent callingIntent = AddTaskActivity.getCallingIntent(context);
            context.startActivity(callingIntent);
        }
    }

    public void navigateToRandomQuote(Context context){
        if(context != null){
            Intent callingIntent = FavActivity.getCallingIntent(context);
            context.startActivity(callingIntent);
        }
    }
}
