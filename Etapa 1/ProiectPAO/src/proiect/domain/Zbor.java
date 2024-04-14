package proiect.domain;

import java.util.AbstractCollection;
import java.util.Date;

public class Zbor {
    private int nr_zbor;
    private String aeroport_destinatie;
    private Date data_zbor;
    private float ore_zbor;
    private int distanta_km;
    Avion avion;

    public static int nr_zboruri=0;

    public Zbor(String aeroport_destinatie, Date data_zbor, float ore_zbor, int distanta_km, Avion avion) {
        this.nr_zbor = nr_zboruri;
        this.aeroport_destinatie = aeroport_destinatie;
        this.data_zbor = data_zbor;
        this.ore_zbor = ore_zbor;
        this.distanta_km = distanta_km;
        this.avion = avion;
        nr_zboruri++;
    }

    public int getNr_zbor() {
        return nr_zbor;
    }

    public void setNr_zbor(int nr_zbor) {
        this.nr_zbor = nr_zbor;
    }

    public String getAeroport_destinatie() {
        return aeroport_destinatie;
    }

    public void setAeroport_destinatie(String aeroport_destinatie) {
        this.aeroport_destinatie = aeroport_destinatie;
    }

    public Date getData_zbor() {
        return data_zbor;
    }

    public void setData_zbor(Date data_zbor) {
        this.data_zbor = data_zbor;
    }

    public float getOre_zbor() {
        return ore_zbor;
    }

    public void setOre_zbor(float ore_zbor) {
        this.ore_zbor = ore_zbor;
    }

    public int getDistanta_km() {
        return distanta_km;
    }

    public void setDistanta_km(int distanta_km) {
        this.distanta_km = distanta_km;
    }

    public Avion getAvion() {
        return avion;
    }

    public void setAvion(Avion avion) {
        this.avion = avion;
    }

    @Override
    public String toString() {
        return "Zbor{" +
                "nr_zbor=" + nr_zbor +
                ", aeroport_destinatie='" + aeroport_destinatie + '\'' +
                ", data_zbor=" + data_zbor +
                ", ore_zbor=" + ore_zbor +
                ", distanta_km=" + distanta_km +
                ", avion=" + avion +
                "} \n";
    }
}
