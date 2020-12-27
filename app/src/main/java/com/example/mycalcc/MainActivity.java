package com.example.mycalcc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    private Button one;
    private Button two;
    private Button three;
    private Button four;
    private Button five;
    private Button six;
    private Button seven;
    private Button eight;
    private Button nine;
    private Button zero;
    private Button dot;
    private TextView mCalcView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();
    }
    private void  init (){
    one = findViewById(R.id.oneBtn);
        two = findViewById(R.id.twoBtn);
        three = findViewById(R.id.threeBtn);
        four = findViewById(R.id.fourBtn);
        five = findViewById(R.id.fiveBtn);
        six = findViewById(R.id.sixBtn);
        seven = findViewById(R.id.sevenBtn);
        eight = findViewById(R.id.eightBtn);
        nine = findViewById(R.id.nineBtn);
        zero = findViewById(R.id.zeroBtn);
        dot = findViewById(R.id.dotBtn);
        one.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
           mCalcView.setText(R.string.oneBtn);

            }

        });
        two.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


            }

        });
    }
}