package com.androidtutoriels.textviewexercise;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView reussi = (TextView)findViewById(R.id.le_texte);
        reussi.setText("J'ai réussi! ouais!");

        ImageView image = (ImageView)findViewById(R.id.imageView);
        image.setImageResource(R.drawable.android1);

    }
}
