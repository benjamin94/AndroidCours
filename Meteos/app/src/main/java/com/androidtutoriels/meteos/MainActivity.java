package com.androidtutoriels.meteos;

import android.os.AsyncTask;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.View;
import android.view.Menu;
import android.view.MenuItem;

import java.io.IOException;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        new TestRequest().execute();

    }

    private class TestRequest extends AsyncTask<Void,Void,Void>{

        @Override
        protected Void doInBackground(Void... params) {
            Log.i("TestRequest","je ne suis pas synchro!");

            String urlTest = "http://api.openweathermap.org/data/2.5/weather?q=London&APPID=21c28e3675f2918f90e632ef85442b77";

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(urlTest)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                Log.i("Reponse",response.toString());
            } catch (IOException e) {
                e.printStackTrace();
            }
            return null;
        }
    }

}
