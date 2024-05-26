package proiect;

import proiect.domain.*;
import proiect.service.AvionService;
import proiect.service.ClientService;
import proiect.service.DepartamentService;
import proiect.service.ZborService;

import java.util.Arrays;
import java.util.Date;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        ZborService serviceZbor = new ZborService();
        ClientService serviceClient = new ClientService();
        DepartamentService serviceDepartamente = new DepartamentService();
        AvionService serviceAvion = new AvionService();

        Scanner scanner = new Scanner(System.in);


        Job[] joburi = new Job[5];
        joburi[0] = new Job("Stewardesa", TipContract.B2B);
        joburi[1] = new Job("Pilot", TipContract.CIM);
        joburi[2] = new Job("Pilot secund", TipContract.PFA);
        joburi[3] = new Job("Angajat HR", TipContract.SRL);
        joburi[4] = new Job("Relatii clienti", TipContract.CIM);

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


        Client[] clienti = new Client[3];
        clienti[0]= new Client("ana","vladescu",25,"ana@gmail.com",234);
        clienti[1]= new Client("maria","georgescu",60,"maria@gmail.com",2356);
        clienti[2]= new Client("raluca","marinescu",18,"raluca@gmail.com",2378);


        Zbor[] zboruri = new Zbor[3];
        zboruri[0] = new Zbor("maldive",new Date(123456789000L),2,200,avioane[2]);
        zboruri[1] = new Zbor("bahamas",new Date(123456789100L),3,400,avioane[3]);
        zboruri[2] = new Zbor("ibiza",new Date(123456789200L),1,100,avioane[1]);

        Zbor[] finalZboruri = zboruri;
        Arrays.sort(zboruri, (a, b) -> {
            int a1 = serviceClient.simulareplata(finalZboruri, a.getNrZbor(),1,"economy");
            int b1 = serviceClient.simulareplata(finalZboruri, b.getNrZbor(),1,"economy");

            return Integer.compare(b1, a1);
        });

        Rezervare rezervare1 = new Rezervare(1,1,500,"business",zboruri[0]);
        Rezervare rezervare2 = new Rezervare(2,2,100,"economy",zboruri[1]);
        Rezervare rezervare3 = new Rezervare(3,1,200,"economy",zboruri[2]);
        Rezervare rezervare4 = new Rezervare(4,2,600,"vip",zboruri[0]);
        Rezervare rezervare5 = new Rezervare(5,1,300,"economy",zboruri[1]);
        clienti[1].addRezervare(rezervare1);
        clienti[2].addRezervare(rezervare2);
        clienti[1].addRezervare(rezervare3);
        clienti[2].addRezervare(rezervare4);
        clienti[2].addRezervare(rezervare5);

        Arrays.sort(clienti, (a, b) -> {
            int a1 = (a.getRezervari() != null) ? a.getRezervari().length : 0;
            int b1 = (b.getRezervari() != null) ? b.getRezervari().length : 0;

            return Integer.compare(a1, b1);
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
                    zboruri=serviceZbor.addZbor(zboruri,avioane);
                    System.out.println(Arrays.toString(zboruri));
                    break;
                case 2:
                    clienti=serviceClient.addClient(clienti);
                    System.out.println(Arrays.toString(clienti));
                    break;
                case 3:
                    clienti=serviceClient.addRezervare(clienti, zboruri);
                    System.out.println(Arrays.toString(clienti));
                    break;
                case 4:
                    serviceClient.showClientRezervare(clienti);
                    break;
                case 5:
                    serviceClient.top3Client(clienti);
                    break;
                case 6:
                    int x= serviceZbor.simulatePay(zboruri);
                    System.out.println("Pretul simularii este de "+ x);
                    break;
                case 7:
                    serviceZbor.showRezervZbor(zboruri, clienti);
                    break;
                case 8:
                    serviceAvion.showAvionZbor(avioane, zboruri);
                    break;
                case 9:
                    serviceZbor.searchZborDestinatie(zboruri);
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
