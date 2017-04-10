package com.androidtutoriels.javapourandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //entiers
        byte jeSuisLeByte = 127;
        short jeSuisLeShort = 12356;
        int entier = 2147483647;
        long jeSuisLeLong = 9000000000000000000L;

        //decimaux
        float leFloat = 100000000000000000000000000000000000000.654f;
        double leDouble = 1000000000000000000000000999999999999798789789789789789789789789789789789.654; // trop grand

        char leCharacter = 'g';

        boolean leVraiFaux = false;

        int a = 5;
        int b = 6;
        short leShort = 20;

        int addition = 2147483647 + b;

        int division = b/a;

        Log.i("Resultat", String.valueOf(division));
    }
}
