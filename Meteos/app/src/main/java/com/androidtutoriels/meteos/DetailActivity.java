package com.androidtutoriels.meteos;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import java.io.Serializable;

public class DetailActivity extends AppCompatActivity {

    public static String LOCATION_CLEF = "Location";
    public static String TEMPS_CLEF = "TempsArray";
    public static String CLIMATINFO_CLEF = "ClimatInfoArray";

    TextView date;
    TextView temperature;
    TextView vent;
    TextView pression;
    TextView humidite;
    TextView location_tv;
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        date = (TextView)findViewById(R.id.date_tv);
        temperature = (TextView)findViewById(R.id.temperature_tv);
        vent = (TextView)findViewById(R.id.vent_tv);
        pression = (TextView)findViewById(R.id.pression_tv);
        humidite = (TextView)findViewById(R.id.humidite_tv);
        location_tv = (TextView)findViewById(R.id.location_tv);

        imageView = (ImageView)findViewById(R.id.imageView);

        Location location = (Location) getIntent().getSerializableExtra(LOCATION_CLEF);
        Temps temps = (Temps) getIntent().getSerializableExtra(TEMPS_CLEF);
        ClimatInfo climatInfo = (ClimatInfo) getIntent().getSerializableExtra(CLIMATINFO_CLEF);

        String dateText = temps.getNomDeJour() + " "
                + temps.getJour() + " "
                + temps.getNomDeMois() + " "
                + temps.getAn();

        date.setText(dateText);
        temperature.setText("temperature: " + (int)climatInfo.getTemperature() + "°C");
        vent.setText("vent: " + climatInfo.getVent_vitesse() + "mps");
        pression.setText("pression: " + (int)climatInfo.getPression() + "hPa");
        humidite.setText("humidite: " + (int)climatInfo.getHumidite() + "%");
        location_tv.setText(location.getVille() + ", " + location.getPays());


        String iconUri = Utilites.getIconUri(climatInfo.getClimat_id());
        int iconId = getResources().getIdentifier(iconUri,null, getPackageName());

        Drawable iconDrawable = getResources().getDrawable(iconId);
        imageView.setImageDrawable(iconDrawable);

    }
}
