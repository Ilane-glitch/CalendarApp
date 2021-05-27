package com.dev.calendarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btn_cal = (Button) findViewById(R.id.btn_cal);
        Button btn_notes = (Button) findViewById(R.id.btn_notes);
        btn_cal.setOnClickListener(this);
        btn_notes.setOnClickListener(this);
    }

    //choix de l'asset a utiliser
    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_cal :
                //cas où appuie sur calendar
                Toast.makeText(this, "Welcome to calendar", Toast.LENGTH_LONG).show();
                Intent intent = new Intent(this, CalendarActivity.class);
                startActivity(intent);
                break;
            case R.id.btn_notes:
                //cas où appuie sur notes
                Toast.makeText(this, "Welcome to Notes", Toast.LENGTH_LONG).show();
                intent = new Intent(this, NotesActivity.class);
                startActivity(intent);
                break ;
            default:
        }
    }
}