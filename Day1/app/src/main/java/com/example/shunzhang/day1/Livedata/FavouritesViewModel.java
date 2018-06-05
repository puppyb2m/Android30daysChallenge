package com.example.shunzhang.day1.Livedata;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.MutableLiveData;
import android.arch.lifecycle.ViewModel;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import com.example.shunzhang.day1.DB.DBSettings;
import com.example.shunzhang.day1.DB.FavouritesDbHelper;
import com.example.shunzhang.day1.Livedata.Room.FavDao;
import com.example.shunzhang.day1.Livedata.Room.FavDatabase;
import com.example.shunzhang.day1.Model.MovieModel;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by shunzhang on 04/06/2018.
 */

public class FavouritesViewModel extends AndroidViewModel {

    // db helper
    private FavouritesDbHelper dbHelper;
    // data
    private MutableLiveData<List<MovieModel>> model;

    // active db helper
    FavouritesViewModel(Application application){
        super(application);
        dbHelper = new FavouritesDbHelper(application);
    }

    // get model
    public MutableLiveData<List<MovieModel>> getFav(){
        if (model == null){
            model = new MutableLiveData<>();
            loadFav();
        }
        return model;
    }

    // load model
    private void loadFav(){
        // data model
        List<MovieModel> newModel = new ArrayList<>();

        // db
        SQLiteDatabase db = dbHelper.getReadableDatabase();

        // cursor
        Cursor cursor = db.query(DBSettings.DBEntry.TABLE, new String[]{
                DBSettings.DBEntry._ID,
                DBSettings.DBEntry.COL_FAV_TITLE,
        },null,null,null,null,null);

        // query data
        while (cursor.moveToNext()){
            // get index of data
            int inxID = cursor.getColumnIndex(DBSettings.DBEntry._ID);
            int inxTitle = cursor.getColumnIndex(DBSettings.DBEntry.COL_FAV_TITLE);

            // get data by index and store in newModel
            newModel.add(new MovieModel(cursor.getInt(inxID),cursor.getString(inxTitle)));
        }

        // close & save data
        cursor.close();
        db.close();
        model.setValue(newModel);
    }

    public void addFav(){
//        FavDao favDao = FavDatabase.getInstance(this).fav();
    }



}




