package com.camera;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

import com.basics.R;

import java.io.File;
import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;


public class CaptureImageActivity extends Activity implements View.OnClickListener {

    private Button button;
    private ImageView imageView;
    static final int REQUEST_IMAGE_CAPTURE = 1;
    static Uri mLocationForPhotos = null;;
    private String imageFileName;
    File image;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.captureimage);

        button = (Button)findViewById(R.id.button);
        imageView = (ImageView)findViewById(R.id.imageView);
        button.setOnClickListener(this);


    }

    private File createImageFilename() {
        File image = null;
        String timeStamp = new SimpleDateFormat("yyyyMMdd_HHmmss").format(new Date());
        imageFileName = "JPEG_" + timeStamp + "_";
        File storageDir = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_PICTURES);
        try {
            image = File.createTempFile(imageFileName, ".jpg", storageDir);
        } catch (IOException e) {
            e.printStackTrace();
        }
               /* prefix */
                 /* suffix */
                /* directory */
        mLocationForPhotos = Uri.parse("file:" + image.getAbsolutePath());
        return image;
    }


    @Override
    public void onClick(View view) {
        switch(view.getId())
        {
            case R.id.button:

                Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
                if(intent.resolveActivity(getPackageManager())!=null)
                    image = createImageFilename();

                if(image!=null)
                    intent.putExtra(MediaStore.EXTRA_OUTPUT, Uri.fromFile(image));
                    startActivityForResult(intent, REQUEST_IMAGE_CAPTURE);
                break;
        }
    }



    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
       // super.onActivityResult(requestCode, resultCode, data);

        if(requestCode == REQUEST_IMAGE_CAPTURE && resultCode == RESULT_OK) {
            Bundle extras = data.getExtras();
            Bitmap imageBitmap = (Bitmap) extras.get("data");

            addPicToGallery();
            setDecodedScaledPic();
        }
    }

    private void setDecodedScaledPic() {
        //get the dimensions of the view
        int targetWidth = imageView.getWidth();
        int targetHeight = imageView.getHeight();

        // Get the dimensions of the bitmap
        BitmapFactory.Options bmpOptions = new BitmapFactory.Options();
        bmpOptions.inJustDecodeBounds = true;
        BitmapFactory.decodeFile(image.getAbsolutePath(), bmpOptions);
        int wid = bmpOptions.outWidth;
        int hei = bmpOptions.outHeight;

        //Determine how much to scale down an image
        int scaleFactor = Math.min(wid/targetWidth, hei/targetHeight);

        //Decode the image file into a bitmap sized to fill the imageview
        bmpOptions.inJustDecodeBounds = false;
        bmpOptions.inSampleSize = scaleFactor;
        bmpOptions.inPurgeable = true;

        Bitmap bitmap = BitmapFactory.decodeFile(image.getAbsolutePath(), bmpOptions);
        imageView.setImageBitmap(bitmap);
    }

    private void addPicToGallery() {

        Intent intengallery = new Intent(Intent.ACTION_MEDIA_SCANNER_SCAN_FILE);
        File f = new File(image.getAbsolutePath());
        Uri uriImage = Uri.fromFile(f);
        intengallery.setData(uriImage);
        this.sendBroadcast(intengallery);
    }
}
