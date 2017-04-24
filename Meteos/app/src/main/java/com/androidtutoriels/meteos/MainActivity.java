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
import android.widget.ImageView;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;

public class MainActivity extends AppCompatActivity {

    TextView  titre_item;
    TextView  max_temp_item;
    TextView  min_temp_item;
    TextView  location_item;
    ImageView image_item;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        titre_item    = (TextView)findViewById(R.id.titre_tv);
        max_temp_item = (TextView)findViewById(R.id.temp_max_tv);
        min_temp_item = (TextView)findViewById(R.id.temp_min_tv);
        location_item = (TextView)findViewById(R.id.ville_tv);
        image_item    = (ImageView) findViewById(R.id.icon_iv);

        new TestRequest().execute();

    }

    private class TestRequest extends AsyncTask<Void,Void,ClimatElement>{

        @Override
        protected ClimatElement doInBackground(Void... params) {
            Log.i("TestRequest","je ne suis pas synchro!");

            String urlTest = "http://api.openweathermap.org/data/2.5/weather?q=London&APPID=21c28e3675f2918f90e632ef85442b77";

            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(urlTest)
                    .build();

            ClimatElement climatElement = null;

            try {
                Response response = client.newCall(request).execute();
                String bodyReponse = response.body().string();
                climatElement = parseJSON(bodyReponse);
                Log.i("Reponse",response.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return climatElement;
        }

        @Override
        protected void onPostExecute(ClimatElement climatElement) {
            super.onPostExecute(climatElement);

            String titreItem = climatElement.getNomDuJour() + " " +
                    climatElement.getJour() + " " +
                    climatElement.getNomDuMois() + " " +
                    climatElement.getAnnee();

            titre_item.setText(titreItem);
            max_temp_item.setText("temp max: " + climatElement.getMaxTemp());
            min_temp_item.setText("temp min: " + climatElement.getMinTemp());
            location_item.setText(climatElement.getLocation());

        }
    }

    private ClimatElement parseJSON(String bodyReponse) throws JSONException {
        JSONObject mainJSON = new JSONObject(bodyReponse);
        String ville = mainJSON.get("name").toString();
        JSONObject sys = mainJSON.getJSONObject("sys");
        String pays = sys.get("country").toString();
        String location = ville + ", " + pays;

        JSONObject main = mainJSON.getJSONObject("main");
        String minTemp = main.get("temp_min").toString();
        String maxTemp = main.get("temp_max").toString();

        String dt = mainJSON.get("dt").toString();
        int timeStamp = Integer.valueOf(dt);
        Calendar mydate = Calendar.getInstance();
        mydate.setTimeInMillis((long)timeStamp*1000);

        String nomDuMois = Utilites.getMois(mydate.get(Calendar.MONTH));
        String nomDuJour = Utilites.getJour(mydate.get(Calendar.DAY_OF_WEEK));

        ClimatElement climatElement = new ClimatElement(
                ville,
                pays,
                location,
                minTemp,
                maxTemp,
                timeStamp,
                nomDuMois,
                nomDuJour,
                mydate.get(Calendar.DAY_OF_MONTH),
                mydate.get(Calendar.MONTH),
                mydate.get(Calendar.YEAR));

        return climatElement;
    }

}

