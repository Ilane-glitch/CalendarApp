package com.dev.calendarapp;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.os.Bundle;
import android.widget.EditText;

public class AddNoteActivity extends AppCompatActivity {
    Toolbar toolbar;
    EditText noteTitle, notesDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_note);

        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        noteTitle = findViewById(R.id.noteTitle);
        notesDetails = findViewById(R.id.noteDetails);
    }
}