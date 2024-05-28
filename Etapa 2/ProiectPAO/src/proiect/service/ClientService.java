package proiect.service;

import proiect.domain.Client;
import proiect.domain.Rezervare;
import proiect.domain.Zbor;

import java.util.*;

public class ClientService {

    public List<Client> addClient(List<Client> clientiList)
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
        clientiList.add(clientNou);
        AuditService.logAction("AddClient");

        Collections.sort(clientiList, new Comparator<Client>() {
            @Override
            public int compare(Client a, Client b) {
                int a1 = (a.getRezervari() != null) ? a.getRezervari().length : 0;
                int b1 = (b.getRezervari() != null) ? b.getRezervari().length : 0;
                return Integer.compare(b1, a1);
            }
        });
        return clientiList;
    }

    public List<Client> addRezervare(List<Client> clientiList, Set<Zbor> zboruri)
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

        for(Client cl: clientiList)
            if(cl.getNrPasaport() == nrClient)
            {
                for(Zbor zb: zboruri)
                    if(zb.getNrZbor() == nrZbor)
                    {
                        Rezervare rezervare = new Rezervare(new Random().nextInt(100),nrPasageri,simulareplata(zboruri,zb.getNrZbor(),nrPasageri,clasa),clasa,zb);
                        cl.addRezervare(rezervare);
                        AuditService.logAction("AddRezervare");
                        Collections.sort(clientiList, new Comparator<Client>() {
                            @Override
                            public int compare(Client a, Client b) {
                                int a1 = (a.getRezervari() != null) ? a.getRezervari().length : 0;
                                int b1 = (b.getRezervari() != null) ? b.getRezervari().length : 0;
                                return Integer.compare(b1, a1);
                            }
                        });
                        return clientiList;
                    }
            }
        System.out.println("Informatii gresite! Incercati din nou!");
        return clientiList;
    }

    public int simulareplata(Set<Zbor> zboruri, int nrZbor, int nrPasageri, String nrClasa)
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



    public void showClientRezervare(List<Client> clientiList)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți numărul pasaportului:");
        int nrPasaport = scanner.nextInt();
        scanner.nextLine();
        boolean ok = true;
        for( Client cl: clientiList)
        {
            if(cl.getNrPasaport() == nrPasaport)
            {
                ok=false;
                AuditService.logAction("ShowClientRezervare");
                Rezervare[] rezervares = cl.getRezervari();
                System.out.println(Arrays.toString(rezervares));
            }
        }
        if(ok == true)
        {
            System.out.println("Informatii gresite! Incercati din nou!");
        }
    }

    public void top3Client(List<Client> clientiList)
    {
        int nr=0;
        AuditService.logAction("Top3Client");
        for(Client cl:clientiList)
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
