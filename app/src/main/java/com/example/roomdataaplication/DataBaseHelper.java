package com.example.roomdataaplication;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.DatabaseConfiguration;
import androidx.room.InvalidationTracker;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteOpenHelper;

@Database(entities = {Expence.class},version =6)
public abstract class DataBaseHelper extends RoomDatabase {
    private static final String DB_NAME = "expencedb";
    private static DataBaseHelper instance;

    public static synchronized DataBaseHelper getDB(Context context){
        if (instance == null){
            instance = Room.databaseBuilder(context,DataBaseHelper.class,DB_NAME)
                    .fallbackToDestructiveMigration()
                    .allowMainThreadQueries()
                    .build();
        }
        return instance;
    }

    public abstract ExpenceDao expenceDao();

}
