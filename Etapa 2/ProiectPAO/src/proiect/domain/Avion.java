package proiect.domain;

public class Avion {
    private int nrAvion;
    private String model;
    private int anFabricatie;
    private int pretPeKm;
    private int nrLocuri;

    public Avion(int nrAvion, String model, int anFabricatie, int pretPeKm, int nrLocuri) {
        this.nrAvion = nrAvion;
        this.model = model;
        this.anFabricatie = anFabricatie;
        this.pretPeKm = pretPeKm;
        this.nrLocuri = nrLocuri;
    }

    public int getNrAvion() {
        return nrAvion;
    }

    public void setNrAvion(int nrAvion) {
        this.nrAvion = nrAvion;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAnFabricatie() {
        return anFabricatie;
    }

    public void setAnFabricatie(int anFabricatie) {
        this.anFabricatie = anFabricatie;
    }

    public int getPretPeKm() {
        return pretPeKm;
    }

    public void setPretPeKm(int pretPeKm) {
        this.pretPeKm = pretPeKm;
    }

    public int getNrLocuri() {
        return nrLocuri;
    }

    public void setNrLocuri(int nrLocuri) {
        this.nrLocuri = nrLocuri;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "nrAvion=" + nrAvion +
                ", model='" + model + '\'' +
                ", anFabricatie=" + anFabricatie +
                ", pretPeKm=" + pretPeKm +
                ", nrLocuri=" + nrLocuri +
                "} \n";
    }
}
