package proiect.domain;

import java.util.Date;

public class Angajat {
    protected String nume;
    protected String prenume;
    protected int varsta;
    protected Date dataAngajare;
    protected int salariu;
    Job job;

    public Angajat(String nume, String prenume, int varsta, Date dataAngajare, int salariu, Job job) {
        this.nume = nume;
        this.prenume = prenume;
        this.varsta = varsta;
        this.dataAngajare = dataAngajare;
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
        return dataAngajare;
    }

    public void setDataAngajare(Date dataAngajare) {
        this.dataAngajare = dataAngajare;
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
                ", dataAngajare=" + dataAngajare +
                ", salariu=" + salariu +
                ", job=" + job.getNume()+
                "} \n";
    }
}
