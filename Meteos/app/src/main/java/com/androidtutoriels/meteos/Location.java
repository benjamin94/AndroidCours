package com.androidtutoriels.meteos;

import java.io.Serializable;

/**
 * Created by benjaminlize on 25/04/2017.
 */

public class Location implements Serializable{

    int id;
    float lat;
    float lon;
    String ville;
    String pays;

    public Location(int id, float lat, float lon, String ville, String pays) {
        this.id = id;
        this.lat = lat;
        this.lon = lon;
        this.ville = ville;
        this.pays = pays;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public float getLat() {
        return lat;
    }

    public void setLat(float lat) {
        this.lat = lat;
    }

    public float getLon() {
        return lon;
    }

    public void setLon(float lon) {
        this.lon = lon;
    }

    public String getVille() {
        return ville;
    }

    public void setVille(String ville) {
        this.ville = ville;
    }

    public String getPays() {
        return pays;
    }

    public void setPays(String pays) {
        this.pays = pays;
    }
}
