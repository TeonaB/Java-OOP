package proiect.domain;

public class Rezervare {
    private int nrRezervare;
    private int nrPasageri;
    private int pret;
    private String clasa;
    Zbor zbor;

    public Rezervare(int nrRezervare, int nrPasageri, int pret, String clasa, Zbor zbor) {
        this.nrRezervare = nrRezervare;
        this.nrPasageri = nrPasageri;
        this.pret = pret;
        this.clasa = clasa;
        this.zbor = zbor;
    }

    public int getNrRezervare() {
        return nrRezervare;
    }

    public void setNrRezervare(int nrRezervare) {
        this.nrRezervare = nrRezervare;
    }

    public int getNrPasageri() {
        return nrPasageri;
    }

    public void setNrPasageri(int nrPasageri) {
        this.nrPasageri = nrPasageri;
    }

    public int getPret() {
        return pret;
    }

    public void setPret(int pret) {
        this.pret = pret;
    }

    public String getClasa() {
        return clasa;
    }

    public void setClasa(String clasa) {
        this.clasa = clasa;
    }

    public Zbor getZbor() {
        return zbor;
    }

    public void setZbor(Zbor zbor) {
        this.zbor = zbor;
    }

    @Override
    public String toString() {
        return "Rezervare{" +
                "nrRezervare=" + nrRezervare +
                ", nrPasageri=" + nrPasageri +
                ", pret=" + pret +
                ", clasa='" + clasa + '\'' +
                ", zbor=" + zbor +
                "} \n";
    }
}
