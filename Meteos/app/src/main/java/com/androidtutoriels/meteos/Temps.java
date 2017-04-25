package com.androidtutoriels.meteos;

/**
 * Created by benjaminlize on 25/04/2017.
 */

public class Temps {

    int dt_unix;
    int an;
    int mois;
    int jour;
    String dt_text;
    String nomDeAn;
    String nomDeMois;
    String nomDeJour;

    public Temps(int dt_unix, String dt_text) {
        this.dt_unix = dt_unix;
        this.dt_text = dt_text;
    }

    public int getDt_unix() {
        return dt_unix;
    }

    public void setDt_unix(int dt_unix) {
        this.dt_unix = dt_unix;
    }

    public int getAn() {
        return an;
    }

    public void setAn(int an) {
        this.an = an;
    }

    public int getMois() {
        return mois;
    }

    public void setMois(int mois) {
        this.mois = mois;
    }

    public int getJour() {
        return jour;
    }

    public void setJour(int jour) {
        this.jour = jour;
    }

    public String getDt_text() {
        return dt_text;
    }

    public void setDt_text(String dt_text) {
        this.dt_text = dt_text;
    }

    public String getNomDeAn() {
        return nomDeAn;
    }

    public void setNomDeAn(String nomDeAn) {
        this.nomDeAn = nomDeAn;
    }

    public String getNomDeMois() {
        return nomDeMois;
    }

    public void setNomDeMois(String nomDeMois) {
        this.nomDeMois = nomDeMois;
    }

    public String getNomDeJour() {
        return nomDeJour;
    }

    public void setNomDeJour(String nomDeJour) {
        this.nomDeJour = nomDeJour;
    }
}
