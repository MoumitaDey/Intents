package com.camera;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.basics.R;


public class MainCameraActivity extends Activity implements View.OnClickListener {

    private Button capture, picture, record;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main_camera);

        capture = (Button) findViewById(R.id.capture);
        picture = (Button) findViewById(R.id.picture);
        record = (Button) findViewById(R.id.record);

        capture.setOnClickListener(this);


    }


    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.capture:
                Intent intentCapture = new Intent(MainCameraActivity.this, CaptureImageActivity.class);
                startActivity(intentCapture);

                break;
        }
    }


}
