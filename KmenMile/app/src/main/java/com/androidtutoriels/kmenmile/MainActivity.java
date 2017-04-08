package com.androidtutoriels.kmenmile;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    double KM_EN_MILE = 0.621371;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText editText = (EditText)findViewById(R.id.nombre_de_km_et);
        final TextView resultat = (TextView)findViewById(R.id.resultat_tv);

        Button button = (Button)findViewById(R.id.valider_b);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(editText.getText());
                int nombreEnKm = Integer.parseInt(text);
                int nombreEnMile = (int) (nombreEnKm * KM_EN_MILE);

                resultat.setText("le résultat est: " + nombreEnMile);
            }
        });
    }
}
