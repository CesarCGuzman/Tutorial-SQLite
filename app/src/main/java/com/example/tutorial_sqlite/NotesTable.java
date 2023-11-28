package com.example.tutorial_sqlite;

import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;

public class NotesTable {
    static final String TABLE_NAME = "notes";
    static final String COLUMN_ID = "_id";
    static final String COLUMN_SUBJECT = "subject";
    static final String COLUMN_TEXT = "note";

    // This gets called when we create the table initially
    static public void onCreate(SQLiteDatabase db){
        StringBuilder sb = new StringBuilder();

        // CREATE TABLE notes (_id: integer, primary key: autoincrement, subject text: not null, note text: not null);
        // This is the SQL command we want to execute to create the table - these are the columns we want to create
        sb.append("CREATE TABLE " + NotesTable.TABLE_NAME + "(");
        sb.append(COLUMN_ID + " integer primary key autoincrement, ");
        sb.append(COLUMN_SUBJECT + " text not null, ");
        sb.append(COLUMN_TEXT + " text not null);");

        try {
            // Execute the SQL command
            db.execSQL(sb.toString());
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }

    // This gets called when we upgrade the table - You do this by changing the version number in DatabaseHelper.java
    static public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion){
        try {
            // Drop the table if it exists
            db.execSQL("DROP TABLE IF EXISTS " + NotesTable.TABLE_NAME);
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
    }
}
