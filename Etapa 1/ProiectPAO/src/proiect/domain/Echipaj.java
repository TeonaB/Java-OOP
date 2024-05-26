package proiect.domain;

import java.util.Arrays;
import java.util.Date;

public class Echipaj {
    private String nume;
    private String rolEchipaj;
    private Date dataInfiintare;
    Angajat[] angajati;

    public Echipaj(String nume, String rolEchipaj, Date dataInfiintare) {
        this.nume = nume;
        this.rolEchipaj = rolEchipaj;
        this.dataInfiintare = dataInfiintare;
    }

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getRolEchipaj() {
        return rolEchipaj;
    }

    public void setRolEchipaj(String rolEchipaj) {
        this.rolEchipaj = rolEchipaj;
    }

    public Date getDataInfiintare() {
        return dataInfiintare;
    }

    public void setDataInfiintare(Date dataInfiintare) {
        this.dataInfiintare = dataInfiintare;
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
                ", rolEchipaj='" + rolEchipaj + '\'' +
                ", dataInfiintare=" + dataInfiintare +
                ", angajati=" + Arrays.toString(angajati) +
                "} \n";
    }
}
