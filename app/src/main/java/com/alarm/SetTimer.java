package com.alarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;

import com.basics.R;


public class SetTimer extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_intent);

        Intent intentAlarm = new Intent(AlarmClock.ACTION_SET_TIMER);
        intentAlarm.putExtra(AlarmClock.EXTRA_LENGTH, 5);
        intentAlarm.putExtra(AlarmClock.EXTRA_SKIP_UI, false);
        intentAlarm.putExtra(AlarmClock.EXTRA_MESSAGE, "Timer");
        if(intentAlarm.resolveActivity(getPackageManager())!=null)
            startActivity(intentAlarm);

    }



}
