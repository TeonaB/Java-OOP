package proiect.domain;

import java.util.Arrays;

public class Departament {
    private String nume;
    private int bugetAnual;

    Angajat[] angajati;

    public Angajat[] getAngajati() {

        return angajati;
    }

    public void setAngajati(Angajat[] angajati) {

        this.angajati = angajati;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public int getBugetAnual() {
        return bugetAnual;
    }

    public void setBugetAnual(int bugetAnual) {
        this.bugetAnual = bugetAnual;
    }

    public Departament(String nume, int bugetAnual) {
        this.nume = nume;
        this.bugetAnual = bugetAnual;
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
        return "Departament{" +
                "nume='" + nume + '\'' +
                ", bugetAnual=" + bugetAnual +
                ", angajati = " + Arrays.toString(angajati) +
                "} \n";
    }
}
