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

    double dbValue1;
    double dbValue2;
    int operation;
    boolean isTwoNumber = true;

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
                resetText();
                operation = 0;
                show_symbol.setText(R.string.sym_min);

            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 1;
                show_symbol.setText(R.string.sym_sum);
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 2;
                show_symbol.setText(R.string.sym_mult);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 3;
                show_symbol.setText(R.string.sym_div);
            }
        });

        btnProc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 4;
                enterNumber1.setHint(R.string.enter_procent);
                show_symbol.setText(R.string.procent_of);
            }
        });

        btnRoten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 5;
                isTwoNumber = false;
                enterNumber1.setVisibility(View.GONE);
                show_symbol.setText(R.string.sym_ruten);

            }
        });

        btnPyta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 6;
                show_symbol.setText(R.string.sym_pytagoras);
                head_title.setText(R.string.formel_pyta);
                enterNumber1.setHint(R.string.text_value_pytaA);
                enterNumber2.setHint(R.string.text_value_pytaB);

            }
        });

        btnAreaCirkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 7;
                isTwoNumber = false;
                enterNumber1.setVisibility(View.GONE);
                show_symbol.setText(R.string.sym_cyrkel_area);
                head_title.setText(R.string.formel_cirkel);
                enterNumber2.setHint(R.string.text_value_radius);
            }
        });

        btnVolymCylind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 8;
                show_symbol.setText(R.string.sym_cylinder);
                head_title.setText(R.string.formel_cylind);
                enterNumber1.setHint(R.string.text_value_radius);
                enterNumber2.setHint(R.string.text_value1_cylinder_height);
            }
        });

        btnlikaMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                getTextInput();
                switcher(operation, dbValue1, dbValue2);
                clearFields();
                resetText();
            }
        });
    }

    private void getTextInput() {

        String value2 = enterNumber2.getText().toString();
        String symbol = show_symbol.getText().toString();

        if (isTwoNumber == true) {

            String value1 = enterNumber1.getText().toString();

            if (TextUtils.isEmpty(value1) && TextUtils.isEmpty(value2)) {
                showError(0);
                return;
            } else if (TextUtils.isEmpty(value1)) {
                showError(1);
                return;
            }
            dbValue1 = Double.parseDouble(value1);
        }

        if (TextUtils.isEmpty(symbol)) {
            showError(3);
            return;
        } else if (TextUtils.isEmpty(value2)) {
            showError(2);
            return;
        }
        dbValue2 = Double.parseDouble(value2);
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
            case 3:
                result.setError("Error");
                break;
        }
    }


    private void switcher(int a, double dbValue1, double dbValue2){

        switch (a){
            case 0:
                double sumMinus = dbValue1 - dbValue2;
                PrintFormat(sumMinus);
                break;
            case 1:
                double sum = dbValue1 + dbValue2;
                PrintFormat(sum);
                break;
            case 2:
                double sumMulti = dbValue1 * dbValue2;
                PrintFormat(sumMulti);
                break;
            case 3:
                double sumDiv = dbValue1 / dbValue2;
                PrintFormat(sumDiv);
                break;
            case 4:
                double sumProc = (dbValue2*dbValue1)/100;
                PrintFormat(sumProc);
                break;
            case 5:
                double sumRoten = Math.sqrt(dbValue2);
                PrintFormat(sumRoten);
                dbValue1 = 0;
                break;
            case 6:
                double sumPyta = Math.sqrt(Math.pow(dbValue1,2) + Math.pow(dbValue2,2));
                PrintFormat(sumPyta);
                break;
            case 7:
                double sumArea = Math.PI*(dbValue2*dbValue2);
                PrintFormat(sumArea);
                break;
            case 8:
                double sumVolym = Math.PI*(dbValue1*dbValue1)*dbValue2;
                PrintFormat(sumVolym);
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
        show_symbol.setText("");
        isTwoNumber = true;
    }
    private void resetText(){

        head_title.setText(R.string.app_name);
        enterNumber1.setVisibility(View.VISIBLE);
        enterNumber1.setHint(R.string.enter_number);
        enterNumber2.setHint(R.string.enter_number);

    }
}




