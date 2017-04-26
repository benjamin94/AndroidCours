package com.androidtutoriels.meteos;

import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import java.io.Serializable;

public class DetailActivity extends AppCompatActivity {

    public static String LOCATION_CLEF = "Location";
    public static String TEMPS_CLEF = "TempsArray";
    public static String CLIMATINFO_CLEF = "ClimatInfoArray";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        Location location = (Location) getIntent().getSerializableExtra(LOCATION_CLEF);
        Temps temps = (Temps) getIntent().getSerializableExtra(TEMPS_CLEF);
        ClimatInfo climatInfo = (ClimatInfo) getIntent().getSerializableExtra(CLIMATINFO_CLEF);

        String iconUri = Utilites.getIconUri(climatInfo.getClimat_id());
        int iconId = getResources().getIdentifier(iconUri,null, getPackageName());

        Drawable iconDrawable = getResources().getDrawable(iconId);
        //icon.setImageDrawable(iconDrawable);

    }
}
