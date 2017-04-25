package com.androidtutoriels.meteos;

import java.util.ArrayList;

/**
 * Created by benjaminlize on 25/04/2017.
 */

public class Climat {

    ArrayList<Temps> tempsArray;
    ArrayList<ClimatInfo> climatInfosArray;
    Location location;

    public Climat(ArrayList<Temps> tempsArray, ArrayList<ClimatInfo> climatInfosArray) {
        this.tempsArray = tempsArray;
        this.climatInfosArray = climatInfosArray;
    }

    public ArrayList<Temps> getTempsArray() {
        return tempsArray;
    }

    public void setTempsArray(ArrayList<Temps> tempsArray) {
        this.tempsArray = tempsArray;
    }

    public ArrayList<ClimatInfo> getClimatInfosArray() {
        return climatInfosArray;
    }

    public void setClimatInfosArray(ArrayList<ClimatInfo> climatInfosArray) {
        this.climatInfosArray = climatInfosArray;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }
}
