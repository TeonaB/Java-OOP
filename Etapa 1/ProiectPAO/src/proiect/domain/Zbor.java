package proiect.domain;

import java.util.AbstractCollection;
import java.util.Date;

public class Zbor {
    private int nrZbor;
    private String aeroportDestinatie;
    private Date dataZbor;
    private float oreZbor;
    private int distantaKm;
    Avion avion;

    public static int nrZboruri=0;

    public Zbor(String aeroportDestinatie, Date dataZbor, float oreZbor, int distantaKm, Avion avion) {
        this.nrZbor = nrZboruri;
        this.aeroportDestinatie = aeroportDestinatie;
        this.dataZbor = dataZbor;
        this.oreZbor = oreZbor;
        this.distantaKm = distantaKm;
        this.avion = avion;
        nrZboruri++;
    }

    public int getNrZbor() {
        return nrZbor;
    }

    public void setNrZbor(int nrZbor) {
        this.nrZbor = nrZbor;
    }

    public String getAeroportDestinatie() {
        return aeroportDestinatie;
    }

    public void setAeroportDestinatie(String aeroportDestinatie) {
        this.aeroportDestinatie = aeroportDestinatie;
    }

    public Date getDataZbor() {
        return dataZbor;
    }

    public void setDataZbor(Date dataZbor) {
        this.dataZbor = dataZbor;
    }

    public float getOreZbor() {
        return oreZbor;
    }

    public void setOreZbor(float oreZbor) {
        this.oreZbor = oreZbor;
    }

    public int getDistantaKm() {
        return distantaKm;
    }

    public void setDistantaKm(int distantaKm) {
        this.distantaKm = distantaKm;
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
                "nrZbor=" + nrZbor +
                ", aeroportDestinatie='" + aeroportDestinatie + '\'' +
                ", dataZbor=" + dataZbor +
                ", oreZbor=" + oreZbor +
                ", distantaKm=" + distantaKm +
                ", avion=" + avion +
                "} \n";
    }
}
