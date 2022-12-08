package com.example.penugasan;

import android.app.Application;
import android.arch.persistence.room.Room;

import com.example.penugasan.room.AppDatabase;

public class AppAplication extends Application {
    public static AppDatabase db;

    @Override
    public void onCreate() {
        super.onCreate();
        db = Room.databaseBuilder(getApplicationContext(),
                AppDatabase.class, "mahasiswa").allowMainThreadQueries().build();
    }
}
