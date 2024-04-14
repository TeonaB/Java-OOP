package proiect.domain;

import java.util.Arrays;
import java.util.Date;

public class Echipaj {
    private String nume;
    private String rol_echipaj;
    private Date data_infiintare;
    Angajat[] angajati;

    public Echipaj(String nume, String rol_echipaj, Date data_infiintare) {
        this.nume = nume;
        this.rol_echipaj = rol_echipaj;
        this.data_infiintare = data_infiintare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getRol_echipaj() {
        return rol_echipaj;
    }

    public void setRol_echipaj(String rol_echipaj) {
        this.rol_echipaj = rol_echipaj;
    }

    public Date getData_infiintare() {
        return data_infiintare;
    }

    public void setData_infiintare(Date data_infiintare) {
        this.data_infiintare = data_infiintare;
    }

    public Angajat[] getAngajati() {
        return angajati;
    }

    public void setAngajati(Angajat[] angajati) {
        this.angajati = angajati;
    }

    public void addAngajat(Angajat angajat) {
        if (angajati == null) {
            angajati = new Angajat[1];
            angajati[0] = angajat;
        }
        else {
            this.angajati = Arrays.copyOf(angajati, angajati.length + 1);
            this.angajati[angajati.length - 1] = angajat;
        }
    }

    @Override
    public String toString() {
        return "Echipaj{" +
                "nume='" + nume + '\'' +
                ", rol_echipaj='" + rol_echipaj + '\'' +
                ", data_infiintare=" + data_infiintare +
                ", angajati=" + Arrays.toString(angajati) +
                "} \n";
    }
}
