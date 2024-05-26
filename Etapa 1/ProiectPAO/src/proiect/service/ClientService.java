package proiect.service;

import proiect.domain.Client;
import proiect.domain.Rezervare;
import proiect.domain.Zbor;

import java.util.Arrays;
import java.util.Objects;
import java.util.Random;
import java.util.Scanner;

public class ClientService {

    public Client[] addClient(Client[] clienti)
    {
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

        Arrays.sort(newArray, (a, b) -> {
            int a1 = (a.getRezervari() != null) ? a.getRezervari().length : 0;
            int b1 = (b.getRezervari() != null) ? b.getRezervari().length : 0;

            return Integer.compare(b1, a1);
        });
        return newArray;
    }

    public Client[] addRezervare(Client[] clienti, Zbor[] zboruri)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți numărul pasaportului clientului:");
        int nrClient = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceți numărul zborului:");
        int nrZbor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceți numărul de pasageri:");
        int nrPasageri = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceți clasa rezervării:");
        String clasa = scanner.nextLine();

        for(Client cl: clienti)
            if(cl.getNrPasaport() == nrClient)
            {
                for(Zbor zb: zboruri)
                    if(zb.getNrZbor() == nrZbor)
                    {
                        Rezervare rezervare = new Rezervare(new Random().nextInt(100),nrPasageri,simulareplata(zboruri,zb.getNrZbor(),nrPasageri,clasa),clasa,zboruri[nrZbor]);
                        cl.addRezervare(rezervare);
                        Arrays.sort(clienti, (a, b) -> {
                            int a1 = (a.getRezervari() != null) ? a.getRezervari().length : 0;
                            int b1 = (b.getRezervari() != null) ? b.getRezervari().length : 0;

                            return Integer.compare(b1, a1);
                        });
                        return clienti;
                    }
            }
        System.out.println("Informatii gresite! Incercati din nou!");
        return clienti;
    }

    public int simulareplata(Zbor[] zboruri, int nrZbor, int nrPasageri, String nrClasa)
    {
        for(Zbor z:zboruri)
            if(z.getNrZbor() == nrZbor)
            {
                int x = z.getAvion().getPretPeKm()*z.getDistantaKm()*nrPasageri;
                if(Objects.equals(nrClasa, "economy"))
                {
                    x = x;
                }
                else if(Objects.equals(nrClasa, "business"))
                {
                    x = x + x%10;
                }
                else if(Objects.equals(nrClasa, "vip"))
                {
                    x = x + x%20;
                }
                else x= 0;

                return x;
            }
        return 0;
    }



    public void showClientRezervare(Client[] clienti)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți numărul pasaportului:");
        int nrPasaport = scanner.nextInt();
        scanner.nextLine();
        boolean ok = true;
        for( Client cl: clienti)
        {
            if(cl.getNrPasaport() == nrPasaport)
            {
                ok=false;
                Rezervare[] rezervares = cl.getRezervari();
                System.out.println(Arrays.toString(rezervares));
            }
        }
        if(ok == true)
        {
            System.out.println("Informatii gresite! Incercati din nou!");
        }
    }

    public void top3Client(Client[] clienti)
    {
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
}
