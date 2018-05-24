
package com.example.shunzhang.day1;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class TaskModel {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("iSFinished")
    @Expose
    private Boolean iSFinished;

    public TaskModel(String title, Boolean iSFinished){
        this.title = title;
        this.iSFinished = iSFinished;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Boolean getISFinished() {
        return iSFinished;
    }

    public void setISFinished(Boolean iSFinished) {
        this.iSFinished = iSFinished;
    }

}
