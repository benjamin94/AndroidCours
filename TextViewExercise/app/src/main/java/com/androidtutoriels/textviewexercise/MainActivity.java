package com.androidtutoriels.textviewexercise;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    TextView reussi;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        reussi = (TextView)findViewById(R.id.le_texte);
        reussi.setText("J'ai réussi! ouais!");

        ImageView image = (ImageView)findViewById(R.id.imageView);
        image.setImageResource(R.drawable.android1);

        final EditText editText = (EditText)findViewById(R.id.editText);

        final Intent intent = new Intent(this,EcranDeux.class);

        final Button button = (Button)findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = String.valueOf(editText.getText());
                reussi.setText(text);
                Log.i("MainActivity","bouton cliqué");
                Toast.makeText(MainActivity.this, text, Toast.LENGTH_SHORT).show();

                startActivity(intent);
            }
        });



    }

    public void onClic(View view){
        reussi.setText("J'ai cliqué sur le bouton");
    }






}
