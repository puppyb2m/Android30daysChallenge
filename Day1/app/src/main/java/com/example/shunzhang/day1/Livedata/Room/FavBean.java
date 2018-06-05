package com.example.shunzhang.day1.Livedata.Room;

import android.arch.persistence.room.ColumnInfo;
import android.arch.persistence.room.Entity;
import android.arch.persistence.room.PrimaryKey;

/**
 * Created by shunzhang on 05/06/2018.
 */

@Entity(tableName = FavDatabase.TABLE_NAME_FAV)
public class FavBean {


    /**
     * id : 1
     * title : title
     */

    @PrimaryKey
    private int id;
    @ColumnInfo
    private String title;

    public int getId() {
        return id;
    }

    public FavBean(int id, String title) {
        this.id = id;
        this.title = title;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }
}
