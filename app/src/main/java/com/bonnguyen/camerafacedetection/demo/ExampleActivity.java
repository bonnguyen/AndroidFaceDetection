package com.bonnguyen.camerafacedetection.demo;

import android.app.Activity;
import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.view.View;

import com.bonnguyen.camerafacedetection.AndroidCameraActivity;
import com.bonnguyen.camerafacedetection.FaceDetectionView;

public class ExampleActivity extends Activity implements View.OnClickListener {
    private static final String TAG = "ExampleActivity";
    private static final int REQUEST_CAMERA = 200;
    private FaceDetectionView ivPhoto;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_example);
        ivPhoto = (FaceDetectionView) findViewById(R.id.ivPhoto);
        ivPhoto.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        if (view == ivPhoto) {
            Intent intent = new Intent(this, AndroidCameraActivity.class);
            startActivityForResult(intent, REQUEST_CAMERA);
        }
    }

    /**
     * Receiving activity result method will be called after closing the camera
     */
    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        if (resultCode == RESULT_OK) {
            if (requestCode == REQUEST_CAMERA && data.hasExtra("url")) {
                String photoPath = data.getStringExtra("url");
                BitmapFactory.Options options = new BitmapFactory.Options();
                options.inPreferredConfig = Bitmap.Config.ARGB_8888;
                Bitmap bitmap = BitmapFactory.decodeFile(photoPath, options);
                ivPhoto.setImageBitmap(bitmap);
            }
        }
    }

}
