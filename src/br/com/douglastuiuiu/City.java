package br.com.douglastuiuiu;

/**
 * Created by douglasg on 11/01/2017.
 */
public class City {

    String ibgeid, uf, name, capital, lon, lat, noaccents, alternativenames, microregion, mesoregion;

    public City() {
    }

    @Override
    public String toString() {
        return ibgeid + " | " + uf + " | " + name + " | " + capital + " | " + lon + " | " + lat + " | " + noaccents + " | " + alternativenames + " | " + microregion + " | " + mesoregion;
    }

    public String getIbgeid() {
        return ibgeid;
    }

    public void setIbgeid(String ibgeid) {
        this.ibgeid = ibgeid;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCapital() {
        return capital;
    }

    public void setCapital(String capital) {
        this.capital = capital;
    }

    public String getLon() {
        return lon;
    }

    public void setLon(String lon) {
        this.lon = lon;
    }

    public String getLat() {
        return lat;
    }

    public void setLat(String lat) {
        this.lat = lat;
    }

    public String getNoaccents() {
        return noaccents;
    }

    public void setNoaccents(String noaccents) {
        this.noaccents = noaccents;
    }

    public String getAlternativenames() {
        return alternativenames;
    }

    public void setAlternativenames(String alternativenames) {
        this.alternativenames = alternativenames;
    }

    public String getMicroregion() {
        return microregion;
    }

    public void setMicroregion(String microregion) {
        this.microregion = microregion;
    }

    public String getMesoregion() {
        return mesoregion;
    }

    public void setMesoregion(String mesoregion) {
        this.mesoregion = mesoregion;
    }
}
