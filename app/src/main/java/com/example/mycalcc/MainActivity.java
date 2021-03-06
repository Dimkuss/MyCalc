package com.example.mycalcc;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.content.pm.PackageManager;
import android.os.Bundle;
import android.os.Environment;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private boolean isUsual = true;
    public static final int REQUEST_CODE_PERMISSION_READ_STORAGE = 11;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final View usual = findViewById(R.id.usualLayout);
        final View unusual = findViewById(R.id.unusualLayout);
        findViewById(R.id.ingenerBtn).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (isUsual){
                    usual.setVisibility(View.GONE);
                    unusual.setVisibility(View.VISIBLE);
                    isUsual = false;
                }

            }
        });
        findViewById(R.id.ingenerBtn1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (!isUsual){
                    unusual.setVisibility(View.GONE);
                    usual.setVisibility(View.VISIBLE);

                    isUsual = true;
                }
            }
        });

        init();
    }
    private void  init (){
        int permissionStatus = ContextCompat.checkSelfPermission(this,
                Manifest.permission.READ_EXTERNAL_STORAGE);
        if (permissionStatus== PackageManager.PERMISSION_DENIED){
            loadImg();
        } else {
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.READ_EXTERNAL_STORAGE},REQUEST_CODE_PERMISSION_READ_STORAGE);
        }



    }
    @Override
    public void onRequestPermissionResult(int requestCode, String[] permissions, int [] grandResults){
        switch (requestCode){
            case REQUEST_CODE_PERMISSION_READ_STORAGE:
                if (grandResults.length>0 && grandResults[0]==PackageManager.PERMISSION_GRANTED){
                    loadImg();
                } else {
                    Toast.makeText(this,"ВЫ НЕ ДАЛИ РАЗРЕШЕНИЕ",Toast.LENGTH_LONG).show();
                    finish();
                }
        }
    }
    private void loadImg(){
        if (isExternalStorageReadable()){
            
        }

    }
    /* Checks if external storage is available for read and write */
    public boolean isExternalStorageWritable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state)) {
            return true;
        }
        return false;
    }
    /* Checks if external storage is available to at least read */
    public boolean isExternalStorageReadable() {
        String state = Environment.getExternalStorageState();
        if (Environment.MEDIA_MOUNTED.equals(state) ||
                Environment.MEDIA_MOUNTED_READ_ONLY.equals(state)) {
            return true;
        }
        return false;
    }

}