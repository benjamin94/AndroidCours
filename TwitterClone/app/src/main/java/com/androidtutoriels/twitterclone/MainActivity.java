package com.androidtutoriels.twitterclone;

import android.content.Context;
import android.content.Intent;
import android.os.Build;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.text.Editable;
import android.view.View;
import android.webkit.CookieManager;
import android.webkit.CookieSyncManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ListView;
import android.widget.Toast;

import com.twitter.sdk.android.Twitter;
import com.twitter.sdk.android.core.TwitterCore;
import com.twitter.sdk.android.core.TwitterSession;
import com.twitter.sdk.android.tweetcomposer.TweetComposer;

public class MainActivity extends AppCompatActivity {

    String utilisateur = "fabric";
    long tweetId = 631879971628183552L;

    Button button;
    ImageButton tweetIB;
    ImageButton logoutIB;
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
        tweetIB = (ImageButton)findViewById(R.id.toolbar_tweet_ib);
        logoutIB = (ImageButton)findViewById(R.id.toolbar_logout_ib);

        //On Click Toolbar
        tweetIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilites.faireTweet(context, "Je fais mes tutos d'Android!");
            }
        });

        logoutIB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Utilites.logoutTwitter(context);
                Intent i = new Intent(getApplicationContext(),LoginActivity.class);
                startActivity(i);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Editable editable = editText.getText();
                String texte = editable.toString();
                Utilites.mettreTimelineDansListView(context, listView, texte);

            }
        });

        //Ecrire au UI
        Utilites.mettreTimelineDansListView(context, listView, utilisateur);

    }


}
