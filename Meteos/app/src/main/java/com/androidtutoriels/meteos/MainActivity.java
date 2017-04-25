package com.androidtutoriels.meteos;

import android.net.Uri;
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

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.net.MalformedURLException;
import java.net.URI;
import java.net.URL;
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

        new Request5Jour().execute();
        //new TestRequest().execute();

    }

    private class Request5Jour extends AsyncTask<Void,Void,ClimatElement[]>{

        @Override
        protected ClimatElement[] doInBackground(Void... params) {

            //String urlString = "http://api.openweathermap.org/data/2.5/forecast?q=London,us&appid=21c28e3675f2918f90e632ef85442b77";

            final String QUERY_PARAM = "q";
            final String APPID_PARAM = "appid";
            final String UNITS_PARAM = "units";

            Uri.Builder uriBuilder = new Uri.Builder();
            uriBuilder.scheme("http")
                    .authority("api.openweathermap.org")
                    .appendPath("data")
                    .appendPath("2.5")
                    .appendPath("forecast")
                    .appendQueryParameter(QUERY_PARAM,"London")
                    .appendQueryParameter(UNITS_PARAM,"metric")
                    .appendQueryParameter(APPID_PARAM,"21c28e3675f2918f90e632ef85442b77")
                    .build();

            URL url = null;

            try {
                url = new URL(uriBuilder.toString());
                int hi = 1;
            } catch (MalformedURLException e) {
                e.printStackTrace();
            }


            OkHttpClient client = new OkHttpClient();

            Request request = new Request.Builder()
                    .url(url)
                    .build();

            try {
                Response response = client.newCall(request).execute();
                String bodyReponse = response.body().string();

                Location location = parseLocation(bodyReponse);

                parseMain(bodyReponse);

                //climatElement = parseJSON(bodyReponse);
                Log.i("Reponse",response.toString());
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }

            return new ClimatElement[0];
        }
    }

    private void parseMain(String bodyReponse) throws JSONException {
        JSONObject mainJSON =  new JSONObject(bodyReponse);
        JSONArray list = mainJSON.getJSONArray("list");

        Temps[] tempsArray = new Temps[list.length()];
        ClimatInfo[] climatInfoArray = new ClimatInfo[list.length()];


        int i = 0;
        for (i=0; i<list.length(); i++){

            JSONObject elementi = list.getJSONObject(i);
            Temps tempsi = parseTemps(elementi);

            //Si temps == 15h je prends
            if (tempsi.dt_text.substring(11,13).equals("15")){

                tempsArray[i] = tempsi;
                climatInfoArray[i] = parseClimatInfo(elementi);
            }

        }
        int hi = 1;

    }

    private Temps parseTemps(JSONObject element0) throws JSONException {
        //Temps
        int dt = element0.getInt("dt");
        String dt_text = element0.getString("dt_txt");
        Temps temps0 = new Temps(dt,dt_text);
        return temps0;
    }

    private ClimatInfo parseClimatInfo(JSONObject element0) throws JSONException {
        //main
        JSONObject main = element0.getJSONObject("main");
        float temperature = (float) main.getDouble("temp");
        float pression = (float) main.getDouble("pressure");
        float humidite = (float) main.getDouble("humidity");

        //weather
        JSONArray weather = element0.getJSONArray("weather");
        JSONObject weather0 = weather.getJSONObject(0);
        int weatherId = weather0.getInt("id");
        String weatherMain = weather0.getString("main");
        String weatherDescription = weather0.getString("description");
        String weatherIcon = weather0.getString("icon");

        //vent
        JSONObject vent = element0.getJSONObject("wind");
        float vent_vitesse = (float)vent.getDouble("speed");

        ClimatInfo climatInfo = new ClimatInfo(temperature,
                pression,
                humidite,
                vent_vitesse,
                weatherMain,
                weatherDescription,
                weatherIcon,
                weatherId);

        return climatInfo;
    }

    private Location parseLocation(String bodyReponse) throws JSONException {
        JSONObject mainJSON =  new JSONObject(bodyReponse);
        JSONObject city = mainJSON.getJSONObject("city");
        int id = city.getInt("id");
        String ville = city.getString("name");
        String pays = city.getString("country");
        JSONObject coord = city.getJSONObject("coord");
        float lat = (float)coord.getDouble("lat");
        float lon = (float)coord.getDouble("lon");

        Location location = new Location(id,lat,lon,ville,pays);

        return location;
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

