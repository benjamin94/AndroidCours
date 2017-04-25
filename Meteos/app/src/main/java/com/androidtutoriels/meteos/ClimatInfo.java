package com.androidtutoriels.meteos;

/**
 * Created by benjaminlize on 25/04/2017.
 */

public class ClimatInfo {

    int climat_id;
    float temperature;
    float pression;
    float humidite;
    float vent_vitesse;
    String climat_main;
    String climat_description;
    String climat_icon;

    public ClimatInfo(float temperature, float pression, float humidite, float vent_vitesse,
                      String climat_main, String climat_description, String climat_icon, int climat_id) {

        this.temperature = temperature;
        this.pression = pression;
        this.humidite = humidite;
        this.vent_vitesse = vent_vitesse;
        this.climat_main = climat_main;
        this.climat_description = climat_description;
        this.climat_icon = climat_icon;
        this.climat_id = climat_id;
    }

    public float getTemperature() {
        return temperature;
    }

    public void setTemperature(float temperature) {
        this.temperature = temperature;
    }

    public float getPression() {
        return pression;
    }

    public void setPression(float pression) {
        this.pression = pression;
    }

    public float getHumidite() {
        return humidite;
    }

    public void setHumidite(float humidite) {
        this.humidite = humidite;
    }

    public float getVent_vitesse() {
        return vent_vitesse;
    }

    public void setVent_vitesse(float vent_vitesse) {
        this.vent_vitesse = vent_vitesse;
    }

    public String getClimat_main() {
        return climat_main;
    }

    public void setClimat_main(String climat_main) {
        this.climat_main = climat_main;
    }

    public String getClimat_description() {
        return climat_description;
    }

    public void setClimat_description(String climat_description) {
        this.climat_description = climat_description;
    }

    public String getClimat_icon() {
        return climat_icon;
    }

    public void setClimat_icon(String climat_icon) {
        this.climat_icon = climat_icon;
    }

    public int getClimat_id() {
        return climat_id;
    }

    public void setClimat_id(int climat_id) {
        this.climat_id = climat_id;
    }
}
