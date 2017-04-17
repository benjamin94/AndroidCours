package com.androidtutoriels.twitterclone;

import android.content.Context;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;

public class MainActivity extends AppCompatActivity {

    String utilisateur = "fabric";
    long tweetId = 631879971628183552L;

    Button button;
    EditText editText;
    ListView listView;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final Context context = getApplicationContext();

        //Initialisation de views
        editText = (EditText)findViewById(R.id.timeline_et);
        button = (Button) findViewById(R.id.timeline_b);
        listView = (ListView)findViewById(R.id.timeline_lv);
        final ConstraintLayout mainLayout = (ConstraintLayout)findViewById(R.id.main_constraint_layout);

        Utilites.mettreTimelineDansListView(context, listView, utilisateur);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable editable = editText.getText();
                String texte = editable.toString();
                Utilites.mettreTimelineDansListView(context, listView, texte);
                
            }
        });
    }

}
