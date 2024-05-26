package proiect.domain;

import java.util.Arrays;

public class Client {
    protected String nume;
    protected String prenume;
    protected int varsta;
    protected String email;
    protected int nrPasaport;
    Rezervare[] rezervari;

    public static int nrClienti=0;

    public Client(String nume, String prenume, int varsta, String email, int nrPasaport) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.email = email;
        this.nrPasaport = nrPasaport;
        nrClienti++;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getPrenume() {
        return prenume;
    }

    public void setPrenume(String prenume) {
        this.prenume = prenume;
    }

    public int getVarsta() {
        return varsta;
    }

    public void setVarsta(int varsta) {
        this.varsta = varsta;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public int getNrPasaport() {
        return nrPasaport;
    }

    public void setNrPasaport(int nrPasaport) {
        this.nrPasaport = nrPasaport;
    }

    public Rezervare[] getRezervari() {
        return rezervari;
    }

    public void setRezervari(Rezervare[] rezervari) {
        this.rezervari = rezervari;
    }

    @Override
    public String toString() {
        return "Client{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", email='" + email + '\'' +
                ", nrPasaport=" + nrPasaport +
                ", rezervari=" + Arrays.toString(rezervari) +
                "} \n";
    }

    public void addRezervare(Rezervare rezerv) {
        if (rezervari == null) {
            rezervari = new Rezervare[1];
            rezervari[0] = rezerv;
        }
        else {
            this.rezervari = Arrays.copyOf(rezervari, rezervari.length + 1);
            this.rezervari[rezervari.length - 1] = rezerv;
        }
    }
}
