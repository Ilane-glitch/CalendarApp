package com.dev.calendarapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.widget.CalendarView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.app.AppCompatDelegate;
import androidx.appcompat.widget.SwitchCompat;

import com.google.android.material.floatingactionbutton.FloatingActionButton;

public class MainActivity extends AppCompatActivity /*implements View.OnClickListener */{

    CalendarView calendarView;
    TextView myDate;
    SwitchCompat switchCompat;
    SharedPreferences sharedPreferences = null;

    //instance interface calendrier
    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        calendarView = findViewById(R.id.calendarView);
        myDate = findViewById(R.id.myDate);

        calendarView.setOnDateChangeListener((view, year, month, dayOfMonth) -> {
            //date selectionnée
            String date = dayOfMonth + "/" + month + "/" + year;
            myDate.setText(date);
        });

        //Gestion bouton flottant
        FloatingActionButton fab = findViewById(R.id.fab_notes);
        Log.d("Main", "fab F-A-B");
        fab.setOnClickListener(view -> startActivity(new Intent(MainActivity.this, NotesActivity.class)));


        //Night Mode
        switchCompat = findViewById(R.id.switchCompat);
        sharedPreferences = getSharedPreferences("night", 0);
        boolean booleanValue = sharedPreferences.getBoolean("night_mode", true);

        if (booleanValue){
            AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
            switchCompat.setChecked(true);
            switchCompat.setButtonDrawable(R.drawable.ic_baseline_wb_sunny_24);
        }

        switchCompat.setOnCheckedChangeListener((buttonView, isChecked) -> {
            if (isChecked){
                //Si checked Activation DarkMode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_YES);
                switchCompat.setChecked(true);
                switchCompat.setButtonDrawable(R.drawable.ic_baseline_wb_sunny_24);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("night_mode", true);
                editor.apply();
            }else {
                //Sinon LightMode
                AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
                switchCompat.setChecked(false);
                switchCompat.setButtonDrawable(R.drawable.ic_baseline_nights_stay_24);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("night_mode", false);
                editor.apply();
            }
        });


    }

}
/* ancienne interface
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
}*/