package com.example.kalkylator;

//Skapad av grupp 4:

//Joakim Andersson
//Joanne Yager
//Sarah Lidberg
//Luca Salmi

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
                operation = 1;
                changeField();
                textSetter(operation);
                etEnterNumber1.setVisibility(View.VISIBLE);
            }
        });

        btnPlus.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 2;
                changeField();
                textSetter(operation);
                etEnterNumber1.setVisibility(View.VISIBLE);
            }
        });

        btnMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 3;
                changeField();
                textSetter(operation);
                etEnterNumber1.setVisibility(View.VISIBLE);
            }
        });

        btnDiv.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 4;
                changeField();
                textSetter(operation);
                etEnterNumber1.setVisibility(View.VISIBLE);
            }
        });

        btnProc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 5;
                changeField();
                textSetter(operation);
                etEnterNumber1.setVisibility(View.VISIBLE);
            }
        });

        btnRoten.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 6;
                textSetter(operation);
            }
        });

        btnPyta.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 7;
                changeField();
                textSetter(operation);
                etEnterNumber1.setVisibility(View.VISIBLE);
            }
        });

        btnAreaCirkel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 8;
                textSetter(operation);
            }
        });

        btnVolymCylind.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                operation = 9;
                changeField();
                textSetter(operation);
                etEnterNumber1.setVisibility(View.VISIBLE);
            }
        });

        btnClearAll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                clearFields();

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
     * (Anropas i onClickListener för varje operationsknapp)
     * <p>
     * - Visar symbolen som motsvarar operationsknappen användaren tryckt på
     * mellan inmatningsfölten
     * - Visar (i fallen där operationen motsvarar en formel) formeln längst upp på sidan
     * - Ändrar hinten i inmatningsfälten i fallen där operationen motsvarar en formel,
     * med text som förtydligar för användaren vilken del av formeln önskad inmatning motsvarar
     * - Tar bort det första inmatningsfältet i de fallen där endast ett värde krävs
     *
     * @param operation motsvarar vilken operationsknapp användaren tryckt på
     */
    private void textSetter(int operation) {
        switch (operation) {
            case 1: //subtraction
                tvHeadTitle.setText(R.string.app_name);
                tvShowSymbol.setText(R.string.sym_min);
                etEnterNumber1.setHint(R.string.enter_number);
                etEnterNumber2.setHint(R.string.enter_number);
                tvShowSymbol.setTextSize(25);
                break;
            case 2: //addition
                tvHeadTitle.setText(R.string.app_name);
                tvShowSymbol.setText(R.string.sym_sum);
                etEnterNumber1.setHint(R.string.enter_number);
                etEnterNumber2.setHint(R.string.enter_number);
                tvShowSymbol.setTextSize(25);
                break;
            case 3: //multiplication
                tvHeadTitle.setText(R.string.app_name);
                tvShowSymbol.setText(R.string.sym_mult);
                etEnterNumber1.setHint(R.string.enter_number);
                etEnterNumber2.setHint(R.string.enter_number);
                tvShowSymbol.setTextSize(25);
                break;
            case 4: //division
                tvHeadTitle.setText(R.string.app_name);
                tvShowSymbol.setText(R.string.sym_div);
                etEnterNumber1.setHint(R.string.enter_number);
                etEnterNumber2.setHint(R.string.enter_number);
                tvShowSymbol.setTextSize(25);
                break;
            case 5: //percentage
                tvHeadTitle.setText(R.string.app_name);
                etEnterNumber1.setHint(R.string.enter_procent);
                tvShowSymbol.setText(R.string.percent_of);
                etEnterNumber2.setHint(R.string.enter_number);
                tvShowSymbol.setTextSize(25);
                break;
            case 6: //root
                tvHeadTitle.setText(R.string.app_name);
                isTwoNumber = false;
                etEnterNumber1.setVisibility(View.GONE);
                tvShowSymbol.setText(R.string.sym_ruten);
                etEnterNumber2.setHint(R.string.enter_number);
                tvShowSymbol.setTextSize(25);
                break;
            case 7: //Pythagoras
                tvShowSymbol.setText(R.string.sym_pytagoras);
                tvHeadTitle.setText(R.string.formel_pyta);
                etEnterNumber1.setHint(R.string.text_value_pytaA);
                etEnterNumber2.setHint(R.string.text_value_pytaB);
                tvShowSymbol.setTextSize(25);
                break;
            case 8: //Area of a circle
                isTwoNumber = false;
                etEnterNumber1.setVisibility(View.GONE);
                tvShowSymbol.setText(R.string.sym_cyrkel_area);
                tvHeadTitle.setText(R.string.formel_cirkel);
                etEnterNumber2.setHint(R.string.text_value_radius);
                tvShowSymbol.setTextSize(25);
                break;
            case 9: //Cylinder volume
                tvShowSymbol.setText(R.string.sym_cylinder);
                tvHeadTitle.setText(R.string.formel_cylind);
                etEnterNumber1.setHint(R.string.text_value_radius);
                etEnterNumber2.setHint(R.string.text_value1_cylinder_height);
                tvShowSymbol.setTextSize(18);
                break;
        }
    }

    /**
     * (Anropas när användaren trycker på LikaMed-knappen eller matar in ett värde i andra
     * inmatningsfältet)
     * <p>
     * Anropar metoder som gör att värdena som användaren matat in och operationsknappen som
     * användaren tryckt på läses av, motsvarade operation utförs.
     */
    private void onInput() {
        getTextInput();
        calculateResult(operation, dbValue1, dbValue2);
    }

    /**
     * (Anropas när användaren trycker på LikaMed-knappen eller matar in ett värde i andra
     * inmatningsfältet, via onInput())
     * <p>
     * - Läser in de värden som användaren matat in i inmatningsfälten
     * - Visar felmeddelande ifall värde saknas i ett obligatoriskt fält
     */
    private void getTextInput() {

        String value1 = etEnterNumber1.getText().toString();
        String value2 = etEnterNumber2.getText().toString();

        if (operation == 0) {
            return;
        }

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

        if (TextUtils.isEmpty(value2)) {
            showError(2);
            return;
        }
        dbValue2 = Double.parseDouble(value2);
    }

    /**
     * (Anropas i onClickListener för alla operationsknappar som kräver två värden)
     * <p>
     * Hoppar till andra inmatningsfältet när användaren matat in ett värde i första inmatningsfältet
     * och tryckt på en operationsknapp
     */
    public void changeField() {
        String temp = etEnterNumber1.getText().toString();

        if (TextUtils.isEmpty(temp)) {
            return;
        }
        etEnterNumber2.requestFocus();
    }

    /**
     * (Anropas i getTextInput())
     * <p>
     * Visar felmeddelande i obligatoriska inmatningsfält som saknar värden.
     *
     * @param id motsvarar vilka felmeddelanden som ska visas
     */

    public void showError(int id) {

        switch (id) {

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
        }
    }


    /**
     * (Anropas när användaren trycker på LikaMed-knappen eller matar in ett värde i andra
     * inmatningsfältet, via onInput())
     * <p>
     * Utför den matematiska operation som motsvarar operationsknappen användaren tryckt på
     * och skickar resultatet till printFormat() som skriver ut resultatet i resultatsrutan
     *
     * @param operation motsvarar vilken operationsknapp användaren tryckt på
     * @param dbValue1  motsvarar värdet som användaren matat in i det första inmatningsfältet
     * @param dbValue2  motsvarar värdet som användaren matat in i det andra inmatningsfältet
     */
    private void calculateResult(int operation, double dbValue1, double dbValue2) {

        double result;

        switch (operation) {
            case 1: //subtraction
                result = dbValue1 - dbValue2;
                printFormat(result);
                break;
            case 2: //addition
                result = dbValue1 + dbValue2;
                printFormat(result);
                break;
            case 3: //multiplication
                result = dbValue1 * dbValue2;
                printFormat(result);
                break;
            case 4: //division
                result = dbValue1 / dbValue2;
                printFormat(result);
                break;
            case 5: //percentage
                result = (dbValue2 * dbValue1) / 100;
                printFormat(result);
                break;
            case 6: //root
                result = Math.sqrt(dbValue2);
                printFormat(result);
                break;
            case 7: //Pythagoras
                result = Math.sqrt(Math.pow(dbValue1, 2) + Math.pow(dbValue2, 2));
                printFormat(result);
                break;
            case 8: //Area of a circle
                result = Math.PI * (dbValue2 * dbValue2);
                printFormat(result);
                break;
            case 9: //Cylinder volume
                result = Math.PI * (dbValue1 * dbValue1) * dbValue2;
                printFormat(result);
                break;
        }
    }

    /**
     * (Anropas i calculateResult())
     * <p>
     * Tar in resultatet av operationen som användaren valt genom att trycka på en operationsknapp,
     * skriver ut resultatet i resultatfältet
     *
     * @param a är det värde som ska skrivas ut i resultatfältet
     */
    private void printFormat(double a) {
        DecimalFormat df = new DecimalFormat("#.#####################");
        String print = df.format(a);
        tvResult.setText(print);
    }

    /**
     * (Anropas när användaren trycker på ClearAll-knappen.
     * <p>
     * - Raderar användarens input från inmatningsfälten
     * - Raderar operationssymbolen mellan inmatningsfälten
     * - Återställer isTwoNumber till true
     * - Återställer det första EditText-fältet till synlig
     * - Återställer texten högst upp på sidan till appens namn
     * - Återställer hinten i EditText-fälten till "Enter Number"
     * - Återställer operationssymbolens storlek
     */
    private void clearFields() {
        tvResult.setText("");
        etEnterNumber1.getText().clear();
        etEnterNumber2.getText().clear();
        tvShowSymbol.setText(R.string.empty_field);
        isTwoNumber = true;
        etEnterNumber1.setVisibility(View.VISIBLE);
        tvHeadTitle.setText(R.string.app_name);
        etEnterNumber1.setHint(R.string.enter_number);
        etEnterNumber2.setHint(R.string.enter_number);
        tvShowSymbol.setTextSize(25);
    }
}



