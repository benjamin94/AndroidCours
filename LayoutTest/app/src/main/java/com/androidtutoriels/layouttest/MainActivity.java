package com.androidtutoriels.layouttest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView texte = (TextView)findViewById(R.id.textView);
        texte.setText("Voici le texte depuis activité Java");

    }
}
