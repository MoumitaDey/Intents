package com.calender;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.provider.CalendarContract;

import com.basics.R;


public class CalenderEvent extends Activity{



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.implicit_intent);

        Intent intentEvent = new Intent(Intent.ACTION_INSERT);
        intentEvent.setData(CalendarContract.Events.CONTENT_URI);
        intentEvent.putExtra(CalendarContract.Events.TITLE, "Birthday Party");
        intentEvent.putExtra(CalendarContract.EXTRA_EVENT_BEGIN_TIME, "Timer");
        intentEvent.putExtra(CalendarContract.EXTRA_EVENT_END_TIME, "Timer");
        if(intentEvent.resolveActivity(getPackageManager())!=null)
            startActivity(intentEvent);

    }



}
