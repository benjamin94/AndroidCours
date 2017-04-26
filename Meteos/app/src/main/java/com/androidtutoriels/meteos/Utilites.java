package com.androidtutoriels.meteos;

/**
 * Created by benjaminlize on 23/04/2017.
 */

public class Utilites {

    static String soleil = "@drawable/sunny";
    static String nuage_peu = "@drawable/clouds-and-sun";
    static String nuage_normal = "@drawable/clouds-and-sun";
    static String nuage_casse = "@drawable/clouds";
    static String pluie_beaucoup = "@drawable/raining";
    static String pluie_normal = "@drawable/raindrops";
    static String eclair = "@drawable/bolt";
    static String neige = "@drawable/snowflake";
    static String brouillard = "@drawable/tornado";



    public static String getMois (int mois){

        String nomDuMois = null;

        switch (mois){
            case 0:
                nomDuMois = "Janvier";
                break;
            case 1:
                nomDuMois = "Fevrier";
                break;
            case 2:
                nomDuMois = "Mars";
                break;
            case 3:
                nomDuMois = "Avril";
                break;
            case 4:
                nomDuMois = "May";
                break;
            case 5:
                nomDuMois = "Juin";
                break;
            case 6:
                nomDuMois = "Juillet";
                break;
            case 7:
                nomDuMois = "Aout";
                break;
            case 8:
                nomDuMois = "Septembre";
                break;
            case 9:
                nomDuMois = "Octobre";
                break;
            case 10:
                nomDuMois = "Novembre";
                break;
            case 11:
                nomDuMois = "Decembre";
                break;
        }

        return nomDuMois;

    }

    public static String getJour (int jour){

        String nomDuJour = null;

        switch (jour){
            case 1:
                nomDuJour = "Dimanche";
                break;
            case 2:
                nomDuJour = "Lundi";
                break;
            case 3:
                nomDuJour = "Mardi";
                break;
            case 4:
                nomDuJour = "Mercredi";
                break;
            case 5:
                nomDuJour = "Jeudi";
                break;
            case 6:
                nomDuJour = "Vendredi";
                break;
            case 7:
                nomDuJour = "Samedi";
                break;
        }
        return nomDuJour;
    }

    public static String getIconUri(int iconId){

        String toReturn = "@drawable/weather";

        if (iconId >= 200 && iconId <= 232 ){
            toReturn = eclair;
        }
        if (iconId >= 300 && iconId <= 321 ){
            toReturn = pluie_beaucoup;
        }
        if (iconId >= 500 && iconId <= 504 ){
            toReturn = pluie_normal;
        }
        if (iconId == 511 ){
            toReturn = neige;
        }
        if (iconId >= 520 && iconId <= 531 ){
            toReturn = pluie_beaucoup;
        }
        if (iconId >= 600 && iconId <= 622 ){
            toReturn = neige;
        }
        if (iconId >= 701 && iconId <= 781 ){
            toReturn = brouillard;
        }
        if (iconId == 800){
            toReturn = soleil;
        }
        if (iconId == 801 ){
            toReturn = nuage_peu;
        }
        if (iconId == 802 ){
            toReturn = nuage_normal;
        }
        if (iconId >= 803 && iconId <= 804 ){
            toReturn = nuage_casse;
        }

        return toReturn;

    }
}
