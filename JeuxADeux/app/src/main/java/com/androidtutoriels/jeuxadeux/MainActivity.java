package com.androidtutoriels.jeuxadeux;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    int scoreJ1;
    int scoreJ2;

    Button boutonJ1;
    Button boutonJ2;

    Button boutonReset;

    TextView textJ1;
    TextView textJ2;

    boolean jeuEnCours;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //pour Joueurs
        boutonJ1 = (Button)findViewById(R.id.joueur1_b);
        boutonJ2 = (Button)findViewById(R.id.joueur2_b);

        //Reset
        boutonReset = (Button)findViewById(R.id.reset_b);

        //Jeu
        textJ1 = (TextView)findViewById(R.id.j1_score_tv);
        textJ2 = (TextView)findViewById(R.id.j2_score_tv);

        reset();

        //onClick J1
        boutonJ1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jeuEnCours){
                    scoreJ1++;
                    textJ1.setText("le score est:" + scoreJ1);
                    if (scoreJ1 == 10){
                        Toast.makeText(MainActivity.this, "Joueur 1 Gagne!", Toast.LENGTH_SHORT).show();
                        jeuEnCours = false;
                    }
                }

            }
        });

        //onClick J2
        boutonJ2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (jeuEnCours){
                    scoreJ2++;
                    textJ2.setText("le score est:" + scoreJ2);
                    if (scoreJ2 == 10){
                        Toast.makeText(MainActivity.this, "Joueur 2 Gagne!", Toast.LENGTH_SHORT).show();
                        jeuEnCours = false;
                    }
                }
            }
        });

        boutonReset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                reset();
            }
        });

    }

    public void reset(){
        jeuEnCours = true;
        scoreJ1 = 0;
        scoreJ2 = 0;
        textJ1.setText("le score est:" + scoreJ1);
        textJ2.setText("le score est:" + scoreJ2);
        Toast.makeText(this, "commencez!", Toast.LENGTH_SHORT).show();
    }

}
