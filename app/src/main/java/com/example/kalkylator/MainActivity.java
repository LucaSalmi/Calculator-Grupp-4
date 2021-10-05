package com.example.kalkylator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    Button btnPlus;
    Button btnMinus;
    Button btnDiv;
    Button btnMulti;
    Button btnRoten;
    Button btnProc;
    Button btnPyta;
    Button btnAreaCirkel;
    Button btnVolymCylind;
    Button btnlikaMed;

    TextView head_title;
    EditText enterNumber1;
    //EditText enterNumber2;

    //TextView show_symbol;
    TextView resultat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        head_title=findViewById(R.id.head_title);
        enterNumber1=findViewById(R.id.enterNumber1);
        //enterNumber2=findViewById(R.id.enterNumber2);
        //show_symbol=findViewById(R.id.show_symbol);
        resultat=findViewById(R.id.resultat);

        btnVolymCylind=findViewById(R.id.btnVolymCylind);
        btnAreaCirkel=findViewById(R.id.btnAreaCirkel);
        btnPyta=findViewById(R.id.btnPyta);
        btnProc=findViewById(R.id.btnProc);
        btnRoten=findViewById(R.id.btnRoten);
        btnMulti=findViewById(R.id.btnMulti);
        btnDiv=findViewById(R.id.btnDiv);
        btnMinus=findViewById(R.id.btnMinus);
        btnPlus=findViewById(R.id.btnPlus);
        btnlikaMed =findViewById(R.id.btnlikaMed);

        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnRoten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnProc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnAreaCirkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnVolymCylind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnPyta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });
        btnlikaMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

            }
        });

    }
    private void switcher(int a){

        switch (a){

            case 0:

        }
    }
    private void minus(int a, int b){
        int sum = a - b;
    }
    private void plus(int a, int b){
        int sum = a + b;
    }
    private void multi(int a, int b){
        int sum = a * b;
    }
    private void div(int a, int b){
        int sum = a / b;
    }
    private void proc(int a, int b){
        int sum = a*b/100;
    }
    private void pyta(int a, int b) {
        double sum = Math.sqrt(Math.pow(a,2) + Math.pow(b,2));
    }
    //private void roten(int a, int b){
        //int sum = Math;
    //}




}




