package com.dev.calendarapp;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.RecyclerView;

public class NotesActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_layout);
        toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        recyclerView = findViewById(R.id.listOfNotes);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflateur = getMenuInflater();
        inflateur.inflate(R.menu.add_menu, menu);
        return true;
    }
}
