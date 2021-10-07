package com.example.kalkylator;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.KeyEvent;
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
    Button btnClearAll;

    TextView tvHeadTitle;
    EditText etEnterNumber1;
    EditText etEnterNumber2;

    TextView tvShowSymbol;
    TextView tvResult;

    double dbValue1;
    double dbValue2;
    int operation;
    boolean isTwoNumber = true;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tvHeadTitle = findViewById(R.id.head_title);
        etEnterNumber1 = findViewById(R.id.enterNumber1);
        etEnterNumber2 = findViewById(R.id.enterNumber2);
        tvShowSymbol = findViewById(R.id.show_symbol);
        tvResult = findViewById(R.id.resultat);

        btnVolymCylind = findViewById(R.id.btnVolymCylind);
        btnAreaCirkel = findViewById(R.id.btnAreaCirkel);
        btnPyta = findViewById(R.id.btnPyta);
        btnProc = findViewById(R.id.btnProc);
        btnRoten = findViewById(R.id.btnRoten);
        btnMulti = findViewById(R.id.btnMulti);
        btnDiv = findViewById(R.id.btnDiv);
        btnMinus = findViewById(R.id.btnMinus);
        btnPlus = findViewById(R.id.btnPlus);
        btnLikaMed = findViewById(R.id.btnlikaMed);
        btnClearAll = findViewById(R.id.btnClearAll);


        btnMinus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 0;
                resetText();
                changeField();
                textSetter(operation);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 1;
                resetText();
                changeField();
                textSetter(operation);
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 2;
                resetText();
                changeField();
                textSetter(operation);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 3;
                resetText();
                changeField();
                textSetter(operation);
            }
        });

        btnProc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 4;
                resetText();
                changeField();
                textSetter(operation);
            }
        });

        btnRoten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 5;
                resetText();
                textSetter(operation);
            }
        });

        btnPyta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 6;
                resetText();
                changeField();
                textSetter(operation);
            }
        });

        btnAreaCirkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 7;
                resetText();
                textSetter(operation);
            }
        });

        btnVolymCylind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 8;
                resetText();
                changeField();
                textSetter(operation);
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                resetText();
                clearFields();
                tvResult.setText(" ");
            }
        });

        etEnterNumber2.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                onInput();
                return false;
            }
        });

        btnLikaMed.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onInput();
            }
        });
    }

    /**
     * Denna metod anropas i onClickListener för varje operationsknapp. Den gör följande:
     *
     * - Lägger in symbolen som motsvarar operationsknappen användaren tryckt på
     * mellan de två inmatningsfölten
     * - Anger (i fallen där operationen motsvarar en formel) formeln längst upp på sidan
     * - Ändrar på hinten i inmatningsfälten i fallen där operationen motsvarar en formel,
     * med text som förtydligar för användaren vilken del av formeln siffran hen matar in motsvarar
     * - Tar bort det första inmatningsfältet i de fallen där operationen endast tar EN siffra
     *
     * @param operation motsvarar vilken operationsknapp användaren tryckt på
     */
    private void textSetter(int operation){
        switch (operation){
            case 0: //subtraction
                tvShowSymbol.setText(R.string.sym_min);
                break;
            case 1: //addition
                tvShowSymbol.setText(R.string.sym_sum);
                break;
            case 2: //multiplication
                tvShowSymbol.setText(R.string.sym_mult);
                break;
            case 3: //division
                tvShowSymbol.setText(R.string.sym_div);
                break;
            case 4: //percentage
                etEnterNumber1.setHint(R.string.enter_procent);
                tvShowSymbol.setText(R.string.percent_of);
                break;
            case 5: //root
                isTwoNumber = false;
                etEnterNumber1.setVisibility(View.GONE);
                tvShowSymbol.setText(R.string.sym_ruten);
                break;
            case 6: //Pythagoras
                tvShowSymbol.setText(R.string.sym_pytagoras);
                tvHeadTitle.setText(R.string.formel_pyta);
                etEnterNumber1.setHint(R.string.text_value_pytaA);
                etEnterNumber2.setHint(R.string.text_value_pytaB);
                break;
            case 7: //Area of a circle
                isTwoNumber = false;
                etEnterNumber1.setVisibility(View.GONE);
                tvShowSymbol.setText(R.string.sym_cyrkel_area);
                tvHeadTitle.setText(R.string.formel_cirkel);
                etEnterNumber2.setHint(R.string.text_value_radius);
                break;
            case 8: //Cylinder volume
                tvShowSymbol.setText(R.string.sym_cylinder);
                tvHeadTitle.setText(R.string.formel_cylind);
                etEnterNumber1.setHint(R.string.text_value_radius);
                etEnterNumber2.setHint(R.string.text_value1_cylinder_height);
                tvShowSymbol.setTextSize(18);
                break;
        }
    }

    /**
     *
     */
    private void onInput(){
        getTextInput();
        switcher(operation, dbValue1, dbValue2);
        clearFields();
        resetText();
    }

    /**
     *
     */
    private void getTextInput() {

        String value1 = etEnterNumber1.getText().toString();
        String value2 = etEnterNumber2.getText().toString();
        String symbol = tvShowSymbol.getText().toString();


        if (isTwoNumber) {

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

    public void changeField(){
        String temp = etEnterNumber1.getText().toString();

        if(TextUtils.isEmpty(temp)){
            return;
        }
        etEnterNumber2.requestFocus();
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
                tvResult.setError("Enter Number");
                break;
        }
    }


    /**
     * Utför den matematiska operationen som motsvarar operationsknappen användaren tryckt på
     * och skickar resultatet till printFormat() som skriver ut resultatet i resultatsrutan
     *
     * @param operation motsvarar vilken operationsknapp användaren tryckt på
     * @param dbValue1 motsvarar siffran som användaren lagt in i det första inmatningsfältet
     * @param dbValue2 motsvarar siffran som användaren lagt in i det andra inmatningsfältet
     */
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

    /**
     * Tar in en double (resultatet av operationen som användaren valt att utföra)
     * och skriver ut den i resultatfältet
     *
     * @param a är ett värde som ska skrivas ut i resultatfältet
     */
    private void printFormat(double a){
        DecimalFormat df = new DecimalFormat("#.#####################");
        String print = df.format(a);
        tvResult.setText(print);
    }

    /**
     * Raderar användarens input från inmatningsfälten efter att användaren trycker på ClearAll-knappen
     * Raderar operationssymbolen mellan inmatningsfälten
     * Återställer isTwoNumber till true så att ...
      */
    private void clearFields(){
        etEnterNumber1.getText().clear();
        etEnterNumber2.getText().clear();
        tvShowSymbol.setText(R.string.empty_field);
        isTwoNumber = true;
    }

    /**
     * Återställer texten högst upp på sidan till appens namn
     * Återställer det första EditText-fältet till synlig
     * Återställer hinten i EditText-fälten till "Enter Number"
     */
    private void resetText(){

        tvHeadTitle.setText(R.string.app_name);
        etEnterNumber1.setVisibility(View.VISIBLE);
        etEnterNumber1.setHint(R.string.enter_number);
        etEnterNumber2.setHint(R.string.enter_number);

    }
}




