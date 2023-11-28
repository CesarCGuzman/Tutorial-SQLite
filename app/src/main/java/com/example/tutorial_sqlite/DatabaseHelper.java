package com.example.tutorial_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

import androidx.annotation.Nullable;

public class DatabaseHelper extends SQLiteOpenHelper {
    final static String DATABASE_NAME = "notes.db";
    final static int DATABASE_VERSION = 2;
    final String TAG = "demo";

    public DatabaseHelper(Context mcontext) {
        super(mcontext, DATABASE_NAME, null, DATABASE_VERSION);
    }

    @Override
    public void onOpen(SQLiteDatabase db) {
        super.onOpen(db);
        Log.d(TAG, "onOpen: ");
    }

    @Override
    public void onCreate(SQLiteDatabase db) {
        NotesTable.onCreate(db);
        Log.d(TAG, "onCreate: ");
    }

    // This is where we would upgrade the database schema, it's called when the database version is changed
    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        // First we call the onUpgrade method of the NotesTable class
        NotesTable.onUpgrade(db, oldVersion, newVersion);
        // Then we call the onCreate method of the NotesTable class - this creates an empty new table
        NotesTable.onCreate(db);

        Log.d(TAG, "onUpgrade: ");
    }
}
