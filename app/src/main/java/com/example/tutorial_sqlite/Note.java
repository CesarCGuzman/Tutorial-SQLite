package com.example.tutorial_sqlite;

public class Note {
    long _id;
    String subject;
    String text;

    public Note() {
    }

    // To create a new note with an id that we choose
    public Note(long _id, String subject, String text) {
        this._id = _id;
        this.subject = subject;
        this.text = text;
    }

    // To create a new note with an id that is auto-generated
    public Note(String subject, String text) {
        this.subject = subject;
        this.text = text;
    }

    public long get_id() {
        return _id;
    }

    public void set_id(long _id) {
        this._id = _id;
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getText() {
        return text;
    }

    public void setText(String text) {
        this.text = text;
    }

    @Override
    public String toString() {
        return "Note{" +
                "_id=" + _id +
                ", subject='" + subject + '\'' +
                ", text='" + text + '\'' +
                '}';
    }
}
