package proiect.service;

import proiect.domain.*;
import java.text.SimpleDateFormat;
import java.time.LocalDate;

import java.util.*;


public class AeroportService {
    public Zbor[] addZbor(Zbor[] zboruri, Avion[] avioane) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti destinatia:");
        String name = scanner.nextLine();

        System.out.print("Introduceti luna:");
        int x = scanner.nextInt();
        System.out.print("Introduceti ziua:");
        int y = scanner.nextInt();
        Date currentDate = new Date(2024,x,y);

        System.out.println("Introduceti distanta in km:");
        int dist = scanner.nextInt();
        float ore = (float) dist /50;

        System.out.println("Introduceti un avion:");
        int avion = scanner.nextInt();

        for(Avion a:avioane)
            if(a.getNr_avion() == avion)
            {
                Zbor zbor = new Zbor(name,currentDate,ore,dist,a);
                int nr = zboruri.length + 1;
                Zbor[] newArray = new Zbor[nr];
                System.arraycopy(zboruri, 0, newArray, 0, zboruri.length);
                newArray[nr - 1] = zbor;

                return newArray;
            }
        return zboruri;
    }

    public Client[] addClient(Client[] clienti) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceți numele clientului:");
        String nume = scanner.nextLine();

        System.out.println("Introduceți prenumele clientului:");
        String prenume = scanner.nextLine();

        System.out.println("Introduceți vârsta clientului:");
        int varsta = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceți email-ul clientului:");
        String email = scanner.nextLine();

        System.out.println("Introduceți numărul de pașaport al clientului:");
        int nrPasaport = scanner.nextInt();

        Client clientNou = new Client(nume, prenume, varsta, email, nrPasaport);
        int nr = clienti.length + 1;
        Client[] newArray = new Client[nr];
        System.arraycopy(clienti, 0, newArray, 0, clienti.length);
        newArray[nr - 1] = clientNou;

        return newArray;
    }

    public Client[] addRezervare(Client[] clienti, Zbor[] zboruri) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți numărul pasaportului clientului:");
        int nrclient = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceți numărul zborului:");
        int nrzbor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceți numărul de pasageri:");
        int nrPasageri = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceți clasa rezervării:");
        String clasa = scanner.nextLine();

        for(Client cl: clienti)
            if(cl.getNr_pasaport() == nrclient)
            {
                for(Zbor zb: zboruri)
                    if(zb.getNr_zbor() == nrzbor)
                    {
                        Rezervare rezervare = new Rezervare(new Random().nextInt(100),nrPasageri,simulareplata(zboruri,zb.getNr_zbor(),nrPasageri,clasa),clasa,zboruri[nrzbor]);
                        cl.addRezervare(rezervare);
                        return clienti;
                    }
            }
        return clienti;
    }

    public void showClientRezervare(Client[] clienti) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți numărul pasaportului:");
        int nrpasaport = scanner.nextInt();
        scanner.nextLine();
        boolean ok = true;
        for( Client cl: clienti)
        {
            if(cl.getNr_pasaport() == nrpasaport)
            {
                ok=false;
                Rezervare[] rezervares = cl.getRezervari();
                System.out.println(Arrays.toString(rezervares));
            }
        }
        if(ok == true)
        {
            System.out.println("Numar gresit!!!!!! Incercati din nou");
        }
    }

    public int simulatePay(Zbor[] zboruri) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți numărul zborului:");
        int nrzbor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceți numărul pasageri:");
        int nrpasageri = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceți clasa rezervării:");
        String nrclasa = scanner.nextLine();

        for(Zbor z:zboruri)
            if(z.getNr_zbor() == nrzbor)
            {
                int x = z.getAvion().getPret_pe_km()*z.getDistanta_km()*nrpasageri;
                if(Objects.equals(nrclasa, "economy"))
                {
                    x = x;
                }
                else if(Objects.equals(nrclasa, "business"))
                {
                    x = x + x%10;
                }
                else if(Objects.equals(nrclasa, "vip"))
                {
                    x = x + x%20;
                }
                else x= 0;

                return x;
            }
        return 0;
    }

    public int simulareplata(Zbor[] zboruri, int nrzbor, int nrpasageri, String nrclasa){
        for(Zbor z:zboruri)
            if(z.getNr_zbor() == nrzbor)
            {
                int x = z.getAvion().getPret_pe_km()*z.getDistanta_km()*nrpasageri;
                if(Objects.equals(nrclasa, "economy"))
                {
                    x = x;
                }
                else if(Objects.equals(nrclasa, "business"))
                {
                    x = x + x%10;
                }
                else if(Objects.equals(nrclasa, "vip"))
                {
                    x = x + x%20;
                }
                else x= 0;

                return x;
            }
        return 0;
    }



    public void top3Client(Client[] clienti) {
        Arrays.sort(clienti, (a, b) -> {
            int a1 = (a.getRezervari() != null) ? a.getRezervari().length : 0;
            int b1 = (b.getRezervari() != null) ? b.getRezervari().length : 0;

            return Integer.compare(b1, a1);
        });

        int nr=0;
        for(Client cl:clienti)
        {
            int nrRezervari = (cl.getRezervari() != null) ? cl.getRezervari().length : 0;
            System.out.println("Numarul de rezervari este" + nrRezervari);
            System.out.println(cl);
            nr++;
            if(nr==3)
                return;
        }
    }

    public void showRezervZbor() {
    }

    public void showAvionZbor() {
    }

    public void searchZborDestinatie() {
    }

    public void showDepartAngajati() {
    }
}
