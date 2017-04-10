package com.androidtutoriels.javapourandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView textView = (TextView)findViewById(R.id.helloworld_tv);

        // AND : &
        // OR : ||

        boolean a = true;
        boolean b = true;
        boolean c = false;

        if (a == true && b == true){
            Log.i("Resultat", "a & b est vrai");
        }

        if (a == true && b == false){
            Log.i("Resultat", "a = vrai & b faux");
        }

        if (a == true || b == false){
            Log.i("Resultat", "a ou b vrai");
        }

        if (a == true && b == true || c == true){
            Log.i("Resultat", "yes!");
        }




    }
}
