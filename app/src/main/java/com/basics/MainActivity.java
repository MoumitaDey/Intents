package com.basics;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.alarm.SetAlarm;
import com.calender.CalenderEvent;
import com.camera.MainCameraActivity;


public class MainActivity extends Activity implements View.OnClickListener {

    private Button intentBasics, alarmIntent, calenderEventIntent, cameraIntent;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        intentBasics = (Button)findViewById(R.id.intentBasics);
        alarmIntent = (Button)findViewById(R.id.alarmIntent);
        calenderEventIntent = (Button)findViewById(R.id.calenderEventIntent);
        cameraIntent = (Button)findViewById(R.id.cameraIntent);

        intentBasics.setOnClickListener(this);
        alarmIntent.setOnClickListener(this);
        calenderEventIntent.setOnClickListener(this);
        cameraIntent.setOnClickListener(this);

    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.intentBasics:
            Intent intentBasics = new Intent(MainActivity.this, ImplicitIntent.class);
            startActivity(intentBasics);
            break;

            case R.id.alarmIntent:
                Intent intentAlarm = new Intent(MainActivity.this, SetAlarm.class);
                startActivity(intentAlarm);
                break;

            case R.id.calenderEventIntent:
                Intent intentCalenderEvent = new Intent(MainActivity.this, CalenderEvent.class);
                startActivity(intentCalenderEvent);
                break;

            case R.id.cameraIntent:
                Intent intentCamera = new Intent(MainActivity.this, MainCameraActivity.class);
                startActivity(intentCamera);
                break;
        }

    }
}
