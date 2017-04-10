package com.androidtutoriels.javapourandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int[] b = {1,3,5,7,9,11,13,15,17};

        int i = 0;

        while (b[i]!=11){
            i++;
        }

        Log.i("Resultat", "la position du 11 est: " + i);

    }
}
