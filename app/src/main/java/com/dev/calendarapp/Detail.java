package com.dev.calendarapp;

import android.content.Intent;
import android.os.Bundle;
import android.os.PersistableBundle;
import android.text.method.ScrollingMovementMethod;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class Detail extends AppCompatActivity {
    long id;

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.d("Detail", "OnCreate 1");
        setContentView(R.layout.activity_detail);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        Log.d("Detail", "OnCreate 2");
        Intent i = getIntent();
        id = i.getLongExtra("ID",0);
        NotesDatabase db = new NotesDatabase(this);
        Note note = db.getNote(id);
        getSupportActionBar().setTitle(note.getTitle());
        TextView details = findViewById(R.id.noteDesc);
        details.setText(note.getContent());
        details.setMovementMethod(new ScrollingMovementMethod());

        FloatingActionButton fab = findViewById(R.id.fab);
        Log.d("Detail", "fab F-A-B");
        fab.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Log.d("Detail", "Dedans le onClick");
                NotesDatabase db = new NotesDatabase(getApplicationContext());
                db.deleteNote(id);
                Toast.makeText(getApplicationContext(),"Note Deleted",Toast.LENGTH_SHORT).show();
                goToMain();
            }
        });
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.edit_menu,menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.edit){
            Intent i = new Intent(this,Edit.class);
            i.putExtra("ID",id);
            startActivity(i);

        }
        return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
    }

    private void goToMain() {
        Intent i = new Intent(this,MainActivity.class);
        startActivity(i);
    }
}
