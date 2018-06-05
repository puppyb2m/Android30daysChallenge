package com.example.shunzhang.day1.DataBinding;

public class DataBindingUserModel {
    String name;
    String email;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public DataBindingUserModel(String name, String email) {
        this.name = name;
        this.email = email;
    }

}
