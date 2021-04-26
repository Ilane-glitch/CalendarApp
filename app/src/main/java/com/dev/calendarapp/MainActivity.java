package com.dev.calendarapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //lancement de l'activité calendrier
        Intent intent = new Intent (MainActivity.this, CalendarActivity.class);
        startActivity(intent);
    }
}