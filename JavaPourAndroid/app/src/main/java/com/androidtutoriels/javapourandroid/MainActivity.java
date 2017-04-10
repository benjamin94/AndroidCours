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

        int[] b = {1,2,3,4,5,6,7,8,9};
        int[] a = new int[b.length];

        int i;
        for (i = 0; i<b.length; i = i+1){
            a[i] = b[i];
            Log.i("Resultat", String.valueOf(a[i]));
        }






    }
}
