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
    Button btnLikaMed;

    TextView twHeadTitle;
    EditText etEnterNumber1;
    EditText etEnterNumber2;

    TextView twShowSymbol;
    TextView twResult;

    double dbValue1;
    double dbValue2;
    int operation;
    boolean isTwoNumber = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        twHeadTitle =findViewById(R.id.head_title);
        etEnterNumber1 =findViewById(R.id.enterNumber1);
        etEnterNumber2 =findViewById(R.id.enterNumber2);
        twShowSymbol =findViewById(R.id.show_symbol);
        twResult =findViewById(R.id.resultat);

        btnVolymCylind=findViewById(R.id.btnVolymCylind);
        btnAreaCirkel=findViewById(R.id.btnAreaCirkel);
        btnPyta=findViewById(R.id.btnPyta);
        btnProc=findViewById(R.id.btnProc);
        btnRoten=findViewById(R.id.btnRoten);
        btnMulti=findViewById(R.id.btnMulti);
        btnDiv=findViewById(R.id.btnDiv);
        btnMinus=findViewById(R.id.btnMinus);
        btnPlus=findViewById(R.id.btnPlus);
        btnLikaMed =findViewById(R.id.btnlikaMed);


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 0;
                twShowSymbol.setText(R.string.sym_min);

            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 1;
                twShowSymbol.setText(R.string.sym_sum);
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 2;
                twShowSymbol.setText(R.string.sym_mult);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 3;
                twShowSymbol.setText(R.string.sym_div);
            }
        });

        btnProc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 4;
                etEnterNumber1.setHint(R.string.enter_procent);
                twShowSymbol.setText(R.string.procent_of);
            }
        });

        btnRoten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 5;
                isTwoNumber = false;
                etEnterNumber1.setVisibility(View.GONE);
                twShowSymbol.setText(R.string.sym_ruten);

            }
        });

        btnPyta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 6;
                twShowSymbol.setText(R.string.sym_pytagoras);
                twHeadTitle.setText(R.string.formel_pyta);
                etEnterNumber1.setHint(R.string.text_value_pytaA);
                etEnterNumber2.setHint(R.string.text_value_pytaB);

            }
        });

        btnAreaCirkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 7;
                isTwoNumber = false;
                etEnterNumber1.setVisibility(View.GONE);
                twShowSymbol.setText(R.string.sym_cyrkel_area);
                twHeadTitle.setText(R.string.formel_cirkel);
                etEnterNumber2.setHint(R.string.text_value_radius);
            }
        });

        btnVolymCylind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                operation = 8;
                twShowSymbol.setText(R.string.sym_cylinder);
                twHeadTitle.setText(R.string.formel_cylind);
                etEnterNumber1.setHint(R.string.text_value_radius);
                etEnterNumber2.setHint(R.string.text_value1_cylinder_height);
                twShowSymbol.setTextSize(18);
            }
        });

        btnLikaMed.setOnClickListener(new View.OnClickListener() {
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

        String value1 = etEnterNumber1.getText().toString();
        String value2 = etEnterNumber2.getText().toString();
        String symbol = twShowSymbol.getText().toString();

        if (isTwoNumber == true) {

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
                etEnterNumber1.setError("Enter Number");
                etEnterNumber2.setError("Enter Number");
                break;
            case 1:
                etEnterNumber1.setError("Enter Number");
                break;
            case 2:
                etEnterNumber2.setError("Enter Number");
                break;
            case 3:
                twResult.setError("Enter Number");
                break;
        }
    }



    private void switcher(int operation, double dbValue1, double dbValue2){

        double result;

        switch (operation){
            case 0: //subtraction
                result = dbValue1 - dbValue2;
                printFormat(result);
                break;
            case 1: //addition
                result = dbValue1 + dbValue2;
                printFormat(result);
                break;
            case 2: //multiplication
                result = dbValue1 * dbValue2;
                printFormat(result);
                break;
            case 3: //division
                result = dbValue1 / dbValue2;
                printFormat(result);
                break;
            case 4: //percentage
                result = (dbValue2*dbValue1)/100;
                printFormat(result);
                break;
            case 5: //root
                result = Math.sqrt(dbValue2);
                printFormat(result);
                break;
            case 6: //Pythagoras
                result = Math.sqrt(Math.pow(dbValue1,2) + Math.pow(dbValue2,2));
                printFormat(result);
                break;
            case 7: //Area of a circle
                result = Math.PI*(dbValue2*dbValue2);
                printFormat(result);
                break;
            case 8: //Cylinder volume
                result = Math.PI*(dbValue1*dbValue1)*dbValue2;
                printFormat(result);
                break;
        }
    }

    private void printFormat(double a){
        DecimalFormat df = new DecimalFormat("#.#####################");
        String print = df.format(a);
        twResult.setText(print);
    }

    /**
     * Raderar Editview fältet efter vi trycker på likaMed
      */
    private void clearFields(){
        etEnterNumber1.getText().clear();
        etEnterNumber2.getText().clear();
        twShowSymbol.setText("");
        isTwoNumber = true;
    }
    private void resetText(){

        twHeadTitle.setText(R.string.app_name);
        etEnterNumber1.setVisibility(View.VISIBLE);
        etEnterNumber1.setHint(R.string.enter_number);
        etEnterNumber2.setHint(R.string.enter_number);

    }
}




