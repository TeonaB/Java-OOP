package proiect.domain;

public class Job {
    private String nume;
    private String contract;

    public String getNume() {
        return nume;
    }

    public void setNume(String nume) {
        this.nume = nume;
    }

    public String getContract() {
        return contract;
    }

    public void setContract(String contract) {
        this.contract = contract;
    }

    public Job(String nume, String contract) {
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
