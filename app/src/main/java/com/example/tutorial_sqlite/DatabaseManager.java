package com.example.tutorial_sqlite;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;

public class DatabaseManager {
    Context mContext;
    SQLiteDatabase mDatabase;
    DatabaseHelper mDatabaseHelper;
    NotesDAO mNotesDAO;

    public DatabaseManager(Context mContext) {
        this.mContext = mContext;
        mDatabaseHelper = new DatabaseHelper(mContext);

        // Get the database instance
        mDatabase = mDatabaseHelper.getWritableDatabase();

        // Create the DAO
        mNotesDAO = new NotesDAO(mDatabase);
    }

    public NotesDAO getmNotesDAO() {
        return mNotesDAO;
    }
}
