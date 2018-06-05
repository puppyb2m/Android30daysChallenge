package com.example.shunzhang.day1.Livedata.Room;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;

import java.util.List;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

/**
 * Created by shunzhang on 05/06/2018.
 */

@Dao
public interface FavDao {

    @Query("Select * from " + FavDatabase.TABLE_NAME_FAV)
    LiveData<List<FavBean>> getFav();

    @Insert(onConflict = REPLACE)
    public void insertNewMessage(FavBean fav);

}
