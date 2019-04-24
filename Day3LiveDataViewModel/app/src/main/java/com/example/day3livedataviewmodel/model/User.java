package com.example.day3livedataviewmodel.model;

import android.util.Log;
import android.util.Patterns;

public class User {
    /**
     * name :
     * email :
     */

    private String password;
    private String email;

    public String getPassword() {
        return password;
    }

    public void setPassword(String name) {
        this.password = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public User(String password, String email) {
        this.password = password;
        this.email = email;
    }

    @Override
    public String toString() {
        return "User{" +
                "password='" + password + '\'' +
                ", email='" + email + '\'' +
                '}';
    }

    public boolean isEmailValid() {
        return Patterns.EMAIL_ADDRESS.matcher(getEmail()).matches();
    }


    public boolean isPasswordLengthGreaterThan5() {
        Log.v("test",getPassword() + "long :" +getPassword().length() );
        return getPassword().length() > 5;
    }

}
