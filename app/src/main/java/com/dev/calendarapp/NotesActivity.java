package com.dev.calendarapp;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class NotesActivity extends AppCompatActivity {
    Toolbar toolbar;
    RecyclerView recyclerView;
    Adapter adapter;
    List<Note> notes;
    TextView noItemText;
    NotesDatabase notesDatabase;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.notes_layout);
        toolbar = findViewById(R.id.toolbar);
        toolbar.setTitleTextColor(getResources().getColor(R.color.white));
        setSupportActionBar(toolbar);
        noItemText = findViewById(R.id.noItemText);
        notesDatabase = new NotesDatabase(this);
        List<Note> allNotes = notesDatabase.getNotes();
        recyclerView = findViewById(R.id.listOfNotes);

        if(allNotes.isEmpty()){
            noItemText.setVisibility(View.VISIBLE);
        }else {
            noItemText.setVisibility(View.GONE);
            //affiche la liste des notes
            displayList(allNotes);
        }
    }

    private void displayList(List<Note> notes) {
        recyclerView.setLayoutManager(new LinearLayoutManager(this));
        adapter = new Adapter(this,notes);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.add_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if (item.getItemId() == R.id.add){
            Toast.makeText(this, "Add New Note", Toast.LENGTH_SHORT).show();
            Intent i = new Intent(this,AddNoteActivity.class);
            startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    protected void onResume() {
        super.onResume();
        List<Note> notes = notesDatabase.getNotes();
        if(notes.isEmpty()){
            noItemText.setVisibility(View.VISIBLE);
        }else {
            noItemText.setVisibility(View.GONE);
            displayList(notes);
        }
    }
}
