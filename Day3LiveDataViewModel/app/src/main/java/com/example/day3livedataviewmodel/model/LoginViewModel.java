package com.example.day3livedataviewmodel.model;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.os.Handler;
import android.util.Log;

//public class LoginViewModel extends ViewModel {
//
//
//    public MutableLiveData<String> errorPassword = new MutableLiveData<>();
//    public MutableLiveData<String> errorEmail = new MutableLiveData<>();
//
//    public MutableLiveData<String> email = new MutableLiveData<>();
//    public MutableLiveData<String> password = new MutableLiveData<>();
//    public MutableLiveData<Integer> busy;
//
//    public MutableLiveData<Integer> getBusy() {
//
//        if (busy == null) {
//            busy = new MutableLiveData<>();
//            busy.setValue(8);
//        }
//
//        return busy;
//    }
//
//
//    public LoginViewModel() {
//
//    }
//
////    private MutableLiveData<User> userMutableLiveData;
////
////    LiveData<User> getUser() {
////        if (userMutableLiveData == null) {
////            userMutableLiveData = new MutableLiveData<>();
////        }
////
////        return userMutableLiveData;
////    }
//
//
//    public void onLoginClicked() {
//        Log.v("info",email.getValue() + "--"+ password.getValue());
////        getBusy().setValue(0); //View.VISIBLE
////        new Handler().postDelayed(new Runnable() {
////            @Override
////            public void run() {
////
////
////                User user = new User(email.getValue(), password.getValue());
////
////                if (!user.isEmailValid()) {
////                    errorEmail.setValue("Enter a valid email address");
////                } else {
////                    errorEmail.setValue(null);
////                }
////
////                if (!user.isPasswordLengthGreaterThan5())
////                    errorPassword.setValue("Password Length should be greater than 5");
////                else {
////                    errorPassword.setValue(null);
////                }
////
////                userMutableLiveData.setValue(user);
////                busy.setValue(8); //8 == View.GONE
////
////            }
////        }, 3000);
//    }
//}

public class LoginViewModel extends ViewModel {
    public MutableLiveData<String> email = new MutableLiveData<>();
    public MutableLiveData<String> password = new MutableLiveData<>();
    public MutableLiveData<Integer> busy;

    public MutableLiveData<String> errorEmail = new MutableLiveData<>();
    public MutableLiveData<String> errorPassword = new MutableLiveData<>();

    public MutableLiveData<User> user = new MutableLiveData<>();

    public MutableLiveData<User> getUser() {
        if (user == null) {
            user = new MutableLiveData<>();
        }
        return user;
    }

    public MutableLiveData<Integer> getBusy() {

        if (busy == null) {
            busy = new MutableLiveData<>();
            busy.setValue(8);
        }

        return busy;
    }

    public LoginViewModel() {

    }

    public void onLoginClicked() {
        busy.setValue(0);

        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                User mUser = new User(password.getValue(),email.getValue());

                if (mUser.isEmailValid()){
                    errorEmail.setValue(null);
                }else {
                    errorEmail.setValue("it should be email");
                }

                if (mUser.isPasswordLengthGreaterThan5()){
                    errorPassword.setValue(null);
                }else {
                    errorPassword.setValue("it should be more than 5");
                }

                user.setValue(mUser);
                busy.setValue(8);
            }
        }, 500);


    }

}
