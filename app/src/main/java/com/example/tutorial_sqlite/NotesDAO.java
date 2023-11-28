package com.example.tutorial_sqlite;

import android.content.ContentValues;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.util.ArrayList;

public class NotesDAO {
    private SQLiteDatabase db;

    public NotesDAO(SQLiteDatabase db) {
        this.db = db;
    }

    public long save(Note note) {
        // Create a container for the values we want to insert
        ContentValues values = new ContentValues();

        // Put the values into the container
        values.put(NotesTable.COLUMN_SUBJECT, note.getSubject());
        values.put(NotesTable.COLUMN_TEXT, note.getText());

        // Insert the values into the table - Returns the id of the new record
        return db.insert(NotesTable.TABLE_NAME, null, values);
    }

    public boolean update(Note note) {
        // Create a container for the values we want to insert
        ContentValues values = new ContentValues();

        // Put the values into the container
        values.put(NotesTable.COLUMN_SUBJECT, note.getSubject());
        values.put(NotesTable.COLUMN_TEXT, note.getText());

        // The update method returns the number of rows affected, so we can use that to determine if the update was successful
        // Return true if the number of rows affected is greater than 0
        return db.update(NotesTable.TABLE_NAME, values, NotesTable.COLUMN_ID + "=?", new String[]{String.valueOf(note.get_id())}) > 0;
    }

    public boolean delete(Note node) {
        // The delete method returns the number of rows affected, so we can use that to determine if the delete was successful
        // Return true if the number of rows affected is greater than 0
        return db.delete(NotesTable.TABLE_NAME, NotesTable.COLUMN_ID + "=?", new String[]{String.valueOf(node.get_id())}) > 0;
    }

    public boolean delete(long id) {
        // The delete method returns the number of rows affected, so we can use that to determine if the delete was successful
        // Return true if the number of rows affected is greater than 0
        return db.delete(NotesTable.TABLE_NAME, NotesTable.COLUMN_ID + "=?", new String[]{String.valueOf(id)}) > 0;
    }

    public Note get(long id) {
        // Create a null note
        Note note = null;

        // Create a cursor and query the database for the note with the given id
        Cursor cursor = db.query(NotesTable.TABLE_NAME,
                new String[]{NotesTable.COLUMN_ID,
                        NotesTable.COLUMN_SUBJECT,
                        NotesTable.COLUMN_TEXT},
        NotesTable.COLUMN_ID + "=?",
                new String[]{String.valueOf(id)}, null, null, null);

        // If the cursor is able to move to the first record, then we know that the query returned a result
        if (cursor.moveToFirst()) {
            note = getNoteFromCursor(cursor);
        }

        return note;
    }

    public ArrayList<Note> getAll() {
        // Create a new ArrayList to hold the notes
        ArrayList<Note> notes = new ArrayList<>();

        // Create a cursor and query the database for all the notes - you do this by leaving the selection and selectionArgs parameters null
        Cursor cursor = db.query(NotesTable.TABLE_NAME,
                new String[]{NotesTable.COLUMN_ID,
                        NotesTable.COLUMN_SUBJECT,
                        NotesTable.COLUMN_TEXT},
                null, null, null, null, null);

        // Loop through the cursor and create a new note for each record - then add the note to the ArrayList
        while (cursor.moveToNext()){
            Note note = getNoteFromCursor(cursor);
            notes.add(note);
        }

        // Return the ArrayList
        return notes;
    }


    // This method is used to create a new note from the cursor
    private Note getNoteFromCursor(Cursor cursor) {
        // Create a new note
        Note note = new Note();

        // Set the values of the note
        note.set_id(cursor.getLong(0));
        note.setSubject(cursor.getString(1));
        note.setText(cursor.getString(2));

        // Return the note
        return note;
    }

}
