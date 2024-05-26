package proiect.domain;

import java.util.Arrays;
import java.util.Date;

public class SefDepartament extends Angajat{
    private int bonusSalariu;
    private String[] mesajeDepartament;
    Departament departament;

    public SefDepartament(String nume, String prenume, int varsta, Date dataAngajare, int salariu, Job job, int bonus, Departament departament) {
        super(nume, prenume, varsta, dataAngajare, salariu, job);
        this.bonusSalariu = bonus;
        this.departament = departament;
    }

    public SefDepartament( Angajat angajat, int bonus, Departament departament){
        super(angajat.nume, angajat.prenume,angajat.varsta,angajat.dataAngajare, angajat.salariu, angajat.job);
        this.bonusSalariu = bonus;
        this.departament = departament;
    }

    public int getBonusSalariu() {
        return bonusSalariu;
    }

    public void setBonusSalariu(int bonusSalariu) {
        this.bonusSalariu = bonusSalariu;
    }

    public String[] getMesajeDepartament() {
        return mesajeDepartament;
    }

    public void setMesajeDepartament(String[] mesajeDepartament) {
        this.mesajeDepartament = mesajeDepartament;
    }

    public Departament getDepartament() {
        return departament;
    }

    public void setDepartament(Departament departament) {
        this.departament = departament;
    }

    @Override
    public String toString() {
        return "SefDepartament{" +
                "departament=" + departament +
                ", nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", dataAngajare=" + dataAngajare +
                ", salariu=" + salariu + bonusSalariu +
                ", mesajele pentru departament sunt = " + Arrays.toString(mesajeDepartament)+
                "} \n";
    }

    public void addMesaj(String mesaj) {
        if (mesajeDepartament == null) {
            mesajeDepartament = new String[1];
            mesajeDepartament[0] = mesaj;
        }
        else {
            this.mesajeDepartament = Arrays.copyOf(mesajeDepartament, mesajeDepartament.length + 1);
            this.mesajeDepartament[mesajeDepartament.length - 1] = mesaj;
        }
    }
}
