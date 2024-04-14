package proiect.domain;

import java.util.Date;

public class Angajat {
    protected String nume;
    protected String prenume;
    protected int varsta;
    protected Date data_angajare;
    protected int salariu;
    Job job;

    public Angajat(String nume, String prenume, int varsta, Date data_angajare, int salariu, Job job) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.data_angajare = data_angajare;
        this.salariu = salariu;
        this.job = job;
    }

    public Job getJob() {
        return job;
    }

    public void setJob(Job job) {
        this.job = job;
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

    public Date getData_angajare() {
        return data_angajare;
    }

    public void setData_angajare(Date data_angajare) {
        this.data_angajare = data_angajare;
    }

    public int getSalariu() {
        return salariu;
    }

    public void setSalariu(int salariu) {
        this.salariu = salariu;
    }

    @Override
    public String toString() {
        return "Angajat{" +
                "nume='" + nume + '\'' +
                ", prenume='" + prenume + '\'' +
                ", varsta=" + varsta +
                ", data_angajare=" + data_angajare +
                ", salariu=" + salariu +
                ", job=" + job.getNume()+
                "} \n";
    }
}
