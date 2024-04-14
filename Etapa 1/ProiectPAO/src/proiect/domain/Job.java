package proiect.domain;

public class Job {
    private String nume;
    TipContract contract;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public TipContract getContract() {
        return contract;
    }

    public void setContract(TipContract contract) {
        this.contract = contract;
    }

    public Job(String nume, TipContract contract) {
        this.nume = nume;
        this.contract = contract;
    }

    @Override
    public String toString() {
        return "Job{" +
                "nume='" + nume + '\'' +
                ", contract=" + contract +
                "} \n";
    }
}
