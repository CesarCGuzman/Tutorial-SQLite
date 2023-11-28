package com.example.tutorial_sqlite;

import androidx.room.Database;
import androidx.room.RoomDatabase;

@Database(version = 1, entities = {RoomNote.class})
public abstract class RoomAppDataBase extends RoomDatabase {
    public abstract RoomNoteDao RoomNoteDao();

}
