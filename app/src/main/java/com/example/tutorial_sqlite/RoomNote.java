package com.example.tutorial_sqlite;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "RoomNotes")
public class RoomNote {

    @PrimaryKey(autoGenerate = true)
    public long id;

    @ColumnInfo
    public String subject;

    @ColumnInfo
    public String note;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getNote() {
        return note;
    }

    public void setNote(String note) {
        this.note = note;
    }

    public RoomNote() {
    }

    public RoomNote(String subject, String note) {
        this.subject = subject;
        this.note = note;
    }

    public RoomNote(long id, String subject, String note) {
        this.id = id;
        this.subject = subject;
        this.note = note;
    }

    @Override
    public String toString() {
        return "RoomNote{" +
                "id=" + id +
                ", subject='" + subject + '\'' +
                ", note='" + note + '\'' +
                '}';
    }
}
