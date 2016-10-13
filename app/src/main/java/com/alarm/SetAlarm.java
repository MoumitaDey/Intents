package com.alarm;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.AlarmClock;

import com.basics.R;


public class SetAlarm extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_intent);


        /*
        One time alarm
        EXTRA_HOUR - hour time
        EXTRA_MINUTES - min time
        EXTRA_MESSAGE - message/title of alarm
         */

        /*
        Daily alarm
        EXTRA_DAYS - daily time([MONDAY, TUESDAY, .....])
        EXTRA_HOUR - hour time
        EXTRA_MINUTES - min time
        EXTRA_MESSAGE - message/title of alarm
        EXTRA_RINGTONE - if ringtone required/name of the ringtone (Uri)
        EXTRA_RINGTONE - VALUE_RINGTONE_SILENT - for no ringtone
         */
        Intent intentAlarm = new Intent(AlarmClock.ACTION_SET_ALARM);
        intentAlarm.putExtra(AlarmClock.EXTRA_HOUR, 00);
        intentAlarm.putExtra(AlarmClock.EXTRA_MINUTES, 40);
        intentAlarm.putExtra(AlarmClock.EXTRA_MESSAGE, "Get up");
        if(intentAlarm.resolveActivity(getPackageManager())!=null)
            startActivity(intentAlarm);



    }



}
