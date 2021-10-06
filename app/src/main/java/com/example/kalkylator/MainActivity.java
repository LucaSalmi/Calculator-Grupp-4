package com.example.kalkylator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.text.DecimalFormat;

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
    double dbValue1;
    double dbValue2;
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
                show_symbol.setText(R.string.sym_min);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 1;
                show_symbol.setText(R.string.sym_sum);
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 2;
                show_symbol.setText(R.string.sym_mult);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 3;
                show_symbol.setText(R.string.sym_div);
            }
        });

        btnProc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 4;
                enterNumber2.setHint(R.string.enter_procent);
                show_symbol.setText(R.string.sym_procent);
            }
        });

        btnRoten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 5;
                enterNumber1.setText(R.string.sym_ruten);
            }
        });

        btnPyta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 6;
                show_symbol.setText(R.string.sym_pytagoras);
            }
        });

        btnAreaCirkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 7;
                show_symbol.setText(R.string.sym_cyrkel_area);
            }
        });

        btnVolymCylind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 8;
                show_symbol.setText(R.string.sym_cylinder);
            }
        });

        btnlikaMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextInput();
                switcher(operation, dbValue1, dbValue2);
                clearFields();
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
        convertToDouble(value1, value2);
    }

    private void convertToDouble(String a, String b){
        dbValue1 = Double.parseDouble(a);
        dbValue2 = Double.parseDouble(b);
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


    private void switcher(int a, double intValue1, double intValue2){

        switch (a){
            case 0:
                double sumMinus = intValue1 - intValue2;
                PrintFormat(sumMinus);
                break;
            case 1:
                double sum = intValue1 + intValue2;
                PrintFormat(sum);
                break;

            case 2:
                double sumMulti = intValue1 * intValue2;
                PrintFormat(sumMulti);
                break;
            case 3:
                double sumDiv = intValue1 / intValue2;
                PrintFormat(sumDiv);
                break;
            case 4:
                double sumProc = (intValue1*intValue2)/100;
                PrintFormat(sumProc);
                break;
           // KOLLA PÅ IGEN
            case 5:
                double sumRoten = Math.sqrt(intValue2);
                PrintFormat(sumRoten);
                break;
            case 6:
                double sumPyta = Math.sqrt(Math.pow(intValue1,2) + Math.pow(intValue2,2));
                PrintFormat(sumPyta);
                break;
            case 7:
                //cyrkel area
                break;
            case 8:
                //cylinders volym
                break;
        }
    }

    private void PrintFormat(double a){
        DecimalFormat df = new DecimalFormat("#.#####################");
        String print = df.format(a);
        result.setText(print);
    }

    /**
     * Raderar Editview fältet efter vi trycker på likaMed
      */
    private void clearFields(){
        enterNumber1.getText().clear();
        enterNumber2.getText().clear();
        enterNumber2.setHint(R.string.enter_number);
    }

    
}




