package com.example.shunzhang.day1;

import android.content.Context;
import android.content.Intent;

import com.example.shunzhang.day1.Dagger.DaggerActivity2;
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
            Intent callingIntent = RandomQuoteActivity.getCallingIntent(context);
            context.startActivity(callingIntent);
        }
    }

    public void navigateToDagger(Context context){
        if(context != null){
            Intent callingIntent = DaggerActivity2.getCallingIntent(context);
            context.startActivity(callingIntent);
        }
    }

    public void navigateToDemo(Context context){
        if(context != null){
            Intent callingIntent = DaggerActivity2.getCallingIntent(context);
            context.startActivity(callingIntent);
        }
    }
}
