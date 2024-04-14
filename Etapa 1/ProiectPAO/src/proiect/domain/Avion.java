package proiect.domain;

public class Avion {
    private int nr_avion;
    private String model;
    private int an_fabricatie;
    private int pret_pe_km;
    private int nr_locuri;

    public Avion(int nr_avion, String model, int an_fabricatie, int pret_pe_km, int nr_locuri) {
        this.nr_avion = nr_avion;
        this.model = model;
        this.an_fabricatie = an_fabricatie;
        this.pret_pe_km = pret_pe_km;
        this.nr_locuri = nr_locuri;
    }

    public int getNr_avion() {
        return nr_avion;
    }

    public void setNr_avion(int nr_avion) {
        this.nr_avion = nr_avion;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getAn_fabricatie() {
        return an_fabricatie;
    }

    public void setAn_fabricatie(int an_fabricatie) {
        this.an_fabricatie = an_fabricatie;
    }

    public int getPret_pe_km() {
        return pret_pe_km;
    }

    public void setPret_pe_km(int pret_pe_km) {
        this.pret_pe_km = pret_pe_km;
    }

    public int getNr_locuri() {
        return nr_locuri;
    }

    public void setNr_locuri(int nr_locuri) {
        this.nr_locuri = nr_locuri;
    }

    @Override
    public String toString() {
        return "Avion{" +
                "nr_avion=" + nr_avion +
                ", model='" + model + '\'' +
                ", an_fabricatie=" + an_fabricatie +
                ", pret_pe_km=" + pret_pe_km +
                ", nr_locuri=" + nr_locuri +
                "} \n";
    }
}
