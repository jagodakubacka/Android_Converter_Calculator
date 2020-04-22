package com.example.przelicznik_walut_lab_a2;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.view.inputmethod.EditorInfo;
import android.widget.Button;
import android.widget.EditText;

import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity {

    //USA money format (12 digits, 2 decimals)
    DecimalFormat usaDf = new DecimalFormat("###,###,###,###.##");
    // naive currency converter (USD to Euros & Colones)
    private final double RON_USD = 0.23;
    private final double UAH_USD = 0.036;
    private final double KRW_USD = 0.00082;
    private final double BRL_USD = 0.19;
    // GUI widgets
    Button Zamien;
    Button Usun;
    EditText Dolary;
    EditText Leje;
    EditText Hrywna;
    EditText Wony;
    EditText Reale;
    Button Wyjdz;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // bind local controls to GUI widgets
        Dolary = (EditText)findViewById(R.id.Dolary);
// make ‘Euros’ box not-editable (no user input)
        Leje = (EditText)findViewById(R.id.Leje);
        Leje.setInputType(EditorInfo.TYPE_NULL);
// No user input. See layout: android:editable=“false”
        Hrywna = (EditText)findViewById(R.id.Hrywna);
        Wony = (EditText)findViewById(R.id.Wony);
        Reale = (EditText)findViewById(R.id.Reale);
        // attach click behavior to buttons

        Wyjdz = (Button) findViewById(R.id.Wyjscie);
        Wyjdz.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });


        Usun = (Button)findViewById(R.id.Usun);
        Usun.setOnClickListener(new OnClickListener() {
            // clear the text boxes
            @Override
            public void onClick(View v) {
                //  txtColones.setText("");
                Leje.setText("");
                Dolary.setText("");
                Hrywna.setText("");
                Wony.setText("");
                Reale.setText("");
            }
        });


        // do the conversion from USD to Euros and Colones
        Zamien = (Button) findViewById(R.id.Zamien);
        Zamien.setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    String usdStr = Dolary.getText().toString();
                    double usd = Double.parseDouble(usdStr);
                    String leje = String.valueOf(usaDf.format(usd / RON_USD));
                    String hrywny = String.valueOf(usaDf.format(usd / UAH_USD));
                    String wony = String.valueOf(usaDf.format(usd/KRW_USD));
                    String reale = String.valueOf(usaDf.format(usd/BRL_USD));
                    Leje.setText(leje);
                    Hrywna.setText(hrywny);
                    Wony.setText(wony);
                    Reale.setText(reale);
                } catch (NumberFormatException e) {
// ignore errors
                }
            }
        });// setOnClick...
    }// onCreate
}// class
