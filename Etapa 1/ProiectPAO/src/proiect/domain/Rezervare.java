package proiect.domain;

public class Rezervare {
    private int nr_rezervare;
    private int nr_pasageri;
    private int pret;
    private String clasa;
    Zbor zbor;

    public Rezervare(int nr_rezervare, int nr_pasageri, int pret, String clasa, Zbor zbor) {
        this.nr_rezervare = nr_rezervare;
        this.nr_pasageri = nr_pasageri;
        this.pret = pret;
        this.clasa = clasa;
        this.zbor = zbor;
    }

    public int getNr_rezervare() {
        return nr_rezervare;
    }

    public void setNr_rezervare(int nr_rezervare) {
        this.nr_rezervare = nr_rezervare;
    }

    public int getNr_pasageri() {
        return nr_pasageri;
    }

    public void setNr_pasageri(int nr_pasageri) {
        this.nr_pasageri = nr_pasageri;
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
                "nr_rezervare=" + nr_rezervare +
                ", nr_pasageri=" + nr_pasageri +
                ", pret=" + pret +
                ", clasa='" + clasa + '\'' +
                ", zbor=" + zbor +
                "} \n";
    }
}
