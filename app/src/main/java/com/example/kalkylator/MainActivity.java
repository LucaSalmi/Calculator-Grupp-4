package com.example.kalkylator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
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
    EditText enterNumber2;

    TextView show_symbol;
    TextView result;

    boolean isEmpty = true;
    int intValue1;
    int intValue2;
    int operation;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        head_title=findViewById(R.id.head_title);
        enterNumber1=findViewById(R.id.enterNumber1);
        enterNumber2=findViewById(R.id.enterNumber2);
        show_symbol=findViewById(R.id.show_symbol);
        result=findViewById(R.id.resultat);

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
                operation = 0;
            }
        });
        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 1;
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
                getTextInput();
                switcher(operation, intValue1, intValue2);

            }
        });

    }

    private void getTextInput(){

        String value1 = enterNumber1.getText().toString();
        String value2 = enterNumber2.getText().toString();

        if(TextUtils.isEmpty(value1) && TextUtils.isEmpty(value2)){
            showError(0);
            isEmpty = true;
            return;
        }else if(TextUtils.isEmpty(value1)){
            showError(1);
            isEmpty = true;
            return;
        }else if(TextUtils.isEmpty(value2)){
            showError(2);
            isEmpty = true;
            return;
        }
        convertToInt(value1, value2);
    }

    private void convertToInt(String a, String b){
        intValue1 = Integer.parseInt(a);
        intValue2 = Integer.parseInt(b);
    }

    public void showError(int id){

        switch (id){

            case 0:
                enterNumber1.setError("Error");
                enterNumber2.setError("Error");
                break;
            case 1:
                enterNumber1.setError("Error");
                break;
            case 2:
                enterNumber2.setError("Error");
                break;

        }
    }


    private void switcher(int a, int intValue1, int intValue2){

        switch (a){

            case 1:
                plus(intValue1,intValue2);

        }
    }
    private void minus(int a, int b){
        int sum = a - b;
    }
    private void plus(int a, int b){
        int sum = a + b;
        result.setText(Integer.toString(sum));
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
    private void roten(int a, int b){
        double sum1 = Math.sqrt(a);
        double sum2 = Math.sqrt(b);
    }




}




