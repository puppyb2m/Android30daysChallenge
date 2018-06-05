package com.example.shunzhang.day1.DB;

import android.provider.BaseColumns;

/**
 * Created by shunzhang on 04/06/2018.
 */

public class DBSettings {

    public static final String DB_NAME = "favourites.db";
    public static final int DB_VERSION = 1;

    public class DBEntry implements BaseColumns {

        public static final String TABLE = "fav";
        public static final String COL_FAV_TITLE = "title";
//        public static final String COL_FAV_DATE = "date";

    }
}
