package com.example.shunzhang.day1.Livedata.Room;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;

/**
 * Created by shunzhang on 05/06/2018.
 */

@Database(entities = FavBean.class, version = 1, exportSchema = false)
public abstract class FavDatabase extends RoomDatabase {
    public static final String DB_NAME = "app_db";
    public static final String TABLE_NAME_FAV = "fav";
    private static FavDatabase favDatabase;

    public abstract FavDao fav();

    public static FavDatabase getInstance(Context context){

        if(favDatabase == null){
            favDatabase = Room.databaseBuilder(context.getApplicationContext(), FavDatabase.class, DB_NAME)
                    .allowMainThreadQueries()
                    .build();
        }
        return favDatabase;
    }

    public static void destroyInstance() {
        favDatabase = null;
    }
}
