package com.androidtutoriels.javapourandroid;

/**
 * Created by benjaminlize on 10/04/2017.
 */

public class Monstre {

    String son = "roaaaaaar!!!";
    boolean faitPeur = false;
    int nombreDeTetes = 1;
    int nombreDeJambes = 0;

    public Monstre(){

    }

    public Monstre(int nombreDeJambes){
        this.nombreDeJambes = nombreDeJambes;

    }

    public Monstre(String nom){

    }

    public Monstre(String nom, int numbreDeJambes){

    }

    public String donneTaDescription(){
        String description = "j'ai " + nombreDeTetes + " tetes" + " Je fais peur?:" + faitPeur +" et mon son est: " + son;
        return description;
    }

    public int getNombreDeJambes(){
        return this.nombreDeJambes;
    }
}
