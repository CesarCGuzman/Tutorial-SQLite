package com.example.tutorial_sqlite;

import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface RoomNoteDao {

    // This is alot easier than what was done before
    // Room does all the work for us

    // Get all notes
    @Query("SELECT * FROM RoomNotes")
    List<RoomNote> getAll();

    // Get a note by id
    @Query("SELECT * FROM RoomNotes WHERE id = :id limit 1")
    RoomNote findById(long id);

    // Get a note by subject - this doesnt have to be exact
    @Query("SELECT * FROM RoomNotes WHERE subject LIKE :subject")
    List<RoomNote> findBySubject(String subject);

    // Get a note by text
    @Update
    void update(RoomNote roomNote);

    // Insert a lot of notes, or just one
    @Insert
    void insertAll(RoomNote... roomNotes);

    // Delete a note
    @Delete
    void delete(RoomNote roomNote);
}
