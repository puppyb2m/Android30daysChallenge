package com.example.shunzhang.day1.DB;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

/**
 * Created by shunzhang on 04/06/2018.
 */

public class FavouritesDbHelper extends SQLiteOpenHelper {
    public FavouritesDbHelper(Context contex) {
        super(contex, DBSettings.DB_NAME, null, DBSettings.DB_VERSION);
    }

    @Override
    public void onCreate(SQLiteDatabase sqLiteDatabase) {
        String createTable = "CREATE TABLE " + DBSettings.DBEntry.TABLE + " ( " +
                DBSettings.DBEntry._ID + " INTEGER PRIMARY KEY AUTOINCREMENT, " +
                DBSettings.DBEntry.COL_FAV_TITLE + " TEXT NOT NULL);";
        sqLiteDatabase.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase sqLiteDatabase, int i, int i1) {
        sqLiteDatabase.execSQL("DROP TABLE IF EXISTS " + DBSettings.DBEntry.TABLE);
        onCreate(sqLiteDatabase);
    }
}
