package com.ruhul.localstorage.room;

import android.content.Context;

import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;

import com.ruhul.localstorage.Todo;

@Database(entities = {Todo.class}, version = 1, exportSchema = false)
public abstract class TodoDatabase extends RoomDatabase {

    public abstract TodoDao todoDao();

    public static volatile TodoDatabase instance;

    public static String Database_Name = "Todo.db";

    public static synchronized TodoDatabase getInstance(Context context) {
        if (instance == null) {
            synchronized (TodoDatabase.class) {
                if (instance == null) {
                    instance = Room.databaseBuilder(context.getApplicationContext(),
                                    TodoDatabase.class, Database_Name)
                            .fallbackToDestructiveMigration()
                            .allowMainThreadQueries()
                            .build();
                }
            }

        }
        return instance;
    }
}
