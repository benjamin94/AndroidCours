package com.androidtutoriels.javapourandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        boolean a = false;
        boolean b = false;

        if (a == true){
            Log.i("Resultat", "Vrai!, bol = " + a);
        } else if (b == false){
            Log.i("Resultat", "Non Vrai!, bol = " + b);
        } else {
            Log.i("Resultat", "else");
        }

        Log.i("Resultat", "fini");

    }
}
