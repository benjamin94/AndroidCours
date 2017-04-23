package com.androidtutoriels.meteos;

/**
 * Created by benjaminlize on 23/04/2017.
 */

class ClimatElement {

    String ville;
    String pays;
    String location;
    String minTemp;
    String maxTemp;
    int    timeStamp;
    String nomDuMois;
    String nomDuJour;

    public ClimatElement(String ville, String pays, String location, String minTemp, String maxTemp, int timeStamp, String nomDuMois, String nomDuJour) {
        this.ville = ville;
        this.pays = pays;
        this.location = location;
        this.minTemp = minTemp;
        this.maxTemp = maxTemp;
        this.timeStamp = timeStamp;
        this.nomDuMois = nomDuMois;
        this.nomDuJour = nomDuJour;
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

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getMinTemp() {
        return minTemp;
    }

    public void setMinTemp(String minTemp) {
        this.minTemp = minTemp;
    }

    public String getMaxTemp() {
        return maxTemp;
    }

    public void setMaxTemp(String maxTemp) {
        this.maxTemp = maxTemp;
    }

    public int getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(int timeStamp) {
        this.timeStamp = timeStamp;
    }

    public String getNomDuMois() {
        return nomDuMois;
    }

    public void setNomDuMois(String nomDuMois) {
        this.nomDuMois = nomDuMois;
    }

    public String getNomDuJour() {
        return nomDuJour;
    }

    public void setNomDuJour(String nomDuJour) {
        this.nomDuJour = nomDuJour;
    }

    public String getnomDuJourVille(){
        return ville;
    }

}
