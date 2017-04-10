package com.androidtutoriels.javapourandroid;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        int nombreDeJambes = 2;

        //Monstre 1
        Monstre monstre = new Monstre(nombreDeJambes);
        String descriptionDuMonstre = monstre.donneTaDescription();
        Log.i("Resultat","La description du monstre est: " + descriptionDuMonstre);
        int nombreDeJambesM1 = monstre.getNombreDeJambes();
        Log.i("Resultat","monstre 1 jambes:" + nombreDeJambesM1);

        //Monstre 2
        Monstre monstre2 = new Monstre();
        int nombreDeJambesM2 = monstre2.getNombreDeJambes();
        Log.i("Resultat","monstre 2 jambes:" + nombreDeJambesM2);

        Utilites.jeSuisHereux();

        //Super Monstre
        SuperMonstre superMonstre = new SuperMonstre();
        String sonDuMonstre = superMonstre.faisMoiPeur();
        Log.i("Resultat","Super Monstre dit:" + sonDuMonstre);

    }


}
