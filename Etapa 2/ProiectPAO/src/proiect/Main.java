package proiect;

import proiect.config.DatabaseConfiguration;
import proiect.config.SetupData;
import proiect.domain.*;
import proiect.repository.AngajatiRepository;
import proiect.repository.DepartamentRepository;
import proiect.repository.EchipajRepository;
import proiect.repository.JobRepository;
import proiect.service.AvionService;
import proiect.service.ClientService;
import proiect.service.DepartamentService;
import proiect.service.ZborService;

import java.sql.SQLException;
import java.util.*;

public class Main {
    public static void main(String[] args) throws SQLException {

        /* ETAPA 2 */

        SetupData setupData = new SetupData();
        setupData.createTable();
        System.out.println("S-a creat baza de date!");

        JobRepository jobRepo = new JobRepository();
        jobRepo.createJob("pilot","B2B");
        jobRepo.createJob("pilot2","B2B");
        System.out.println(jobRepo.getJob(1));
        jobRepo.deleteJob(2);
        jobRepo.updateJob(1,"curatenie2","SRL");
        jobRepo.createJob("curatenie","PFA");
        jobRepo.getAllJobs();

        DepartamentRepository depRepo = new DepartamentRepository();
        depRepo.createDep("dep1",2200);
        depRepo.createDep("dep2",3554);
        System.out.println(depRepo.getDep(1));
        depRepo.deleteDep(2);
        depRepo.updateDep(1,"dep3",1111);
        depRepo.createDep("dep4",2342);
        depRepo.getAllDep();

        EchipajRepository echipajRepo = new EchipajRepository();
        echipajRepo.createEchipaj("aviatie","piloti", java.sql.Date.valueOf("2024-06-15"));
        echipajRepo.createEchipaj("ajutoare","smurd", java.sql.Date.valueOf("2023-04-07"));
        System.out.println(echipajRepo.getEchipaj(1));
        echipajRepo.deleteEchipaj(2);
        echipajRepo.updateEchipaj(1,"chelneri","servicii", java.sql.Date.valueOf("2022-08-09"));
        echipajRepo.getAllEchipaj();

        AngajatiRepository angajRepo = new AngajatiRepository();
        angajRepo.createAngajat("maria","ioana",23, java.sql.Date.valueOf("2022-06-15"), 2300,22,3,1);
        angajRepo.createAngajat("georgia","teona",11, java.sql.Date.valueOf("2021-06-14"), 5600,23,4,3);
        angajRepo.createAngajat("tudor","ionel",40, java.sql.Date.valueOf("2020-08-10"), 2300,22,1,4);
        angajRepo.getAngajat(1);
        angajRepo.deleteAngaj(2);
        angajRepo.updateAngaj(1,"maria2","ioana2",33,java.sql.Date.valueOf("2022-06-15"),4500,24,3,3);
        angajRepo.getAllAngaj();


        DatabaseConfiguration.closeDatabaseConnection();




        /* ETAPA 1 */

        ZborService serviceZbor = new ZborService();
        ClientService serviceClient = new ClientService();
        DepartamentService serviceDepartamente = new DepartamentService();
        AvionService serviceAvion = new AvionService();

        Scanner scanner = new Scanner(System.in);


        Job[] joburi = new Job[5];
        joburi[0] = new Job("Stewardesa", "B2B");
        joburi[1] = new Job("Pilot", "CIM");
        joburi[2] = new Job("Pilot secund", "PFA");
        joburi[3] = new Job("Angajat HR", "SRL");
        joburi[4] = new Job("Relatii clienti", "CIM");

        Angajat[] angajati = new Angajat[5];
        angajati[0] = new Angajat("Popescu", "Ion", 30, new Date(123456789000L), 5000, joburi[1]);
        angajati[1] = new Angajat("Ionescu", "Maria", 25, new Date(123456790000L), 3500, joburi[2]);
        angajati[2] = new Angajat("Vasilescu", "Andrei", 22, new Date(123456791000L), 2500, joburi[3]);
        angajati[3] = new Angajat("Georgescu", "Ana", 28, new Date(123456792000L), 4500, joburi[4]);
        angajati[4] = new Angajat("Constantinescu", "Mihai", 35, new Date(123456793000L), 6000, joburi[0]);

        Avion[] avioane = new Avion[5];
        avioane[0] = new Avion(1, "Boeing 737", 2010, 10, 150);
        avioane[1] = new Avion(2, "Airbus A320", 2008, 12, 180);
        avioane[2] = new Avion(3, "Boeing 777", 2015, 15, 250);
        avioane[3] = new Avion(4, "Airbus A350", 2019, 18, 220);
        avioane[4] = new Avion(5, "Embraer E190", 2005, 8, 100);

        Departament[] departamente = new Departament[3];
        departamente[0] = new Departament("Pilotaj", 1000000);
        departamente[1] = new Departament("HR", 800000);
        departamente[2] = new Departament("Clienti", 1200000);
        departamente[0].addAngajat(angajati[0]);
        departamente[0].addAngajat(angajati[1]);
        departamente[0].addAngajat(angajati[4]);
        departamente[1].addAngajat(angajati[2]);
        departamente[2].addAngajat(angajati[3]);

        Echipaj[] echipaje = new Echipaj[3];
        echipaje[0] = new Echipaj("Echipaj 1", "Pilotaj", new Date(123456789000L));
        echipaje[1] = new Echipaj("Echipaj 2", "Birou Stuff", new Date(123456789100L));
        echipaje[2] = new Echipaj("Echipaj 3", "Altele", new Date(123456789200L));
        echipaje[0].addAngajat(angajati[0]);
        echipaje[0].addAngajat(angajati[1]);
        echipaje[0].addAngajat(angajati[4]);
        echipaje[1].addAngajat(angajati[2]);
        echipaje[1].addAngajat(angajati[3]);

        SefDepartament[] sefi= new SefDepartament[3];
        sefi[0] = new SefDepartament(angajati[0], 2000, departamente[0]);
        sefi[1] = new SefDepartament(angajati[3], 2500, departamente[1]);
        sefi[2] = new SefDepartament(angajati[4], 3000, departamente[2]);

        List<Client> clientiList = new ArrayList<>();
        clientiList.add(new Client("ana","vladescu",25,"ana@gmail.com",234));
        clientiList.add(new Client("maria","georgescu",60,"maria@gmail.com",2356));
        clientiList.add(new Client("raluca","marinescu",18,"raluca@gmail.com",2378));


        Set<Zbor> zborSet = new TreeSet<>();
        zborSet.add(new Zbor("maldive",new Date(123456789000L),2,200,avioane[2]));
        zborSet.add(new Zbor("bahamas",new Date(123456789100L),3,400,avioane[3]));
        zborSet.add(new Zbor("ibiza",new Date(123456789200L),1,100,avioane[1]));


        Iterator<Zbor> iterator = zborSet.iterator();
        Zbor primulZbor = iterator.next();
        Rezervare rezervare1 = new Rezervare(2, 2, 100, "economy", primulZbor);
        Rezervare rezervare4 = new Rezervare(4,2,600,"vip",primulZbor);
        Zbor alDoileaZbor = iterator.next();
        Rezervare rezervare2 = new Rezervare(2,2,100,"economy",alDoileaZbor);
        Rezervare rezervare5 = new Rezervare(5,1,300,"economy",alDoileaZbor);
        Zbor alTreileaZbor = iterator.next();
        Rezervare rezervare3 = new Rezervare(3,1,200,"economy",alTreileaZbor);
        clientiList.get(1).addRezervare(rezervare1);
        clientiList.get(1).addRezervare(rezervare3);
        clientiList.get(2).addRezervare(rezervare2);
        clientiList.get(2).addRezervare(rezervare4);
        clientiList.get(2).addRezervare(rezervare5);


        Collections.sort(clientiList, new Comparator<Client>() {
            @Override
            public int compare(Client a, Client b) {
                int a1 = (a.getRezervari() != null) ? a.getRezervari().length : 0;
                int b1 = (b.getRezervari() != null) ? b.getRezervari().length : 0;
                return Integer.compare(b1, a1);
            }
        });


        while (true) {
            System.out.println("Alege un numar:");
            System.out.println("1. Adauga zbor");
            System.out.println("2. Adauga client");
            System.out.println("3. Adauga rezervare");
            System.out.println("4. Afiseaza un client cu rezervarile sale");
            System.out.println("5. Top 3 clienti");
            System.out.println("6. Simulare plata pentru un zbor");
            System.out.println("7. Afisare rezervari zbor");
            System.out.println("8. Afisare detalii avion si zborurile sale");
            System.out.println("9. Cautare zbor cu o anumita destinatie");
            System.out.println("10. Afisare detalii departament cu angajati");
            System.out.println("11. Exit");
            int option = scanner.nextInt();
            switch (option) {
                case 1:
                    zborSet=serviceZbor.addZbor(zborSet,avioane);
                    System.out.println(zborSet);
                    break;
                case 2:
                    clientiList=serviceClient.addClient(clientiList);
                    System.out.println(clientiList);
                    break;
                case 3:
                    clientiList=serviceClient.addRezervare(clientiList, zborSet);
                    System.out.println(clientiList);
                    break;
                case 4:
                    serviceClient.showClientRezervare(clientiList);
                    break;
                case 5:
                    serviceClient.top3Client(clientiList);
                    break;
                case 6:
                    int x= serviceZbor.simulatePay(zborSet);
                    System.out.println("Pretul simularii este de "+ x);
                    break;
                case 7:
                    serviceZbor.showRezervZbor(zborSet, clientiList);
                    break;
                case 8:
                    serviceAvion.showAvionZbor(avioane, zborSet);
                    break;
                case 9:
                    serviceZbor.searchZborDestinatie(zborSet);
                    break;
                case 10:
                    serviceDepartamente.showDepartAngajati(departamente, sefi);
                    break;
                case 11:
                    System.exit(0);
            }
        }

    }
}
