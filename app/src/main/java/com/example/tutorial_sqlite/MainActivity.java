package com.example.tutorial_sqlite;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {
    DatabaseManager dm;
    private static final String TAG = "demo";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        dm = new DatabaseManager(this);

        // Create a new note - Commented out because we don't want to create a new note every time we run the app
        //dm.getmNotesDAO().save(new Note("Subject 1", "Text 1"));
        //dm.getmNotesDAO().save(new Note("Subject 2", "Text 2"));
        //dm.getmNotesDAO().save(new Note("Subject 3", "Text 3"));

        // Delete a note via the id
        dm.getmNotesDAO().delete(1);
        dm.getmNotesDAO().delete(2);

        // Get note with id 3 and update it
        Note note = dm.getmNotesDAO().get(3);

        if (note != null) {
            // These are the values we want to update
            note.setSubject("Subject 3 Updated");
            note.setText("Text 3 Updated");

            // Update the note
            dm.getmNotesDAO().update(note);
        }

        Log.d(TAG, "onCreate: " + dm.getmNotesDAO().getAll());
    }
}
