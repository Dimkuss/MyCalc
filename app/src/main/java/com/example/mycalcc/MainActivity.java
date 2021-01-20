package com.example.mycalcc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private boolean isUsual = true;


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
                    usual.setVisibility(View.INVISIBLE);
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



    }
}