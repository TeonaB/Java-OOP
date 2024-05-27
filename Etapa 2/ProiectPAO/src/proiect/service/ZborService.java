package proiect.service;

import proiect.domain.Avion;
import proiect.domain.Client;
import proiect.domain.Rezervare;
import proiect.domain.Zbor;

import java.sql.SQLOutput;
import java.util.*;

public class ZborService {

    public Set<Zbor> addZbor(Set<Zbor> zboruri, Avion[] avioane)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceti destinatia:");
        String name = scanner.nextLine().toLowerCase();

        System.out.print("Introduceti luna:");
        int x = scanner.nextInt();
        System.out.print("Introduceti ziua:");
        int y = scanner.nextInt();
        Date currentDate = new Date(2024,x,y);

        System.out.println("Introduceti distanta in km:");
        int dist = scanner.nextInt();
        float ore = (float) dist /50;

        System.out.println("Introduceti un numar de avion:");
        int nrAvion = scanner.nextInt();

        for(Avion a:avioane)
            if(a.getNrAvion() == nrAvion)
            {
                Zbor zbor = new Zbor(name,currentDate,ore,dist,a);
                zboruri.add(zbor);

                return zboruri;
            }

        System.out.println("Informatii gresite! Incercati din nou!");
        return zboruri;
    }

    public int simulatePay(Set<Zbor> zboruri)
    {
        Scanner scanner = new Scanner(System.in);

        System.out.println("Introduceți numărul zborului:");
        int nrZbor = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceți numărul pasageri:");
        int nrPasageri = scanner.nextInt();
        scanner.nextLine();

        System.out.println("Introduceți clasa rezervării:");
        String nrClasa = scanner.nextLine().toLowerCase();

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
        System.out.println("Informatii gresite! Incercati din nou!");
        return 0;
    }

    public void showRezervZbor(Set<Zbor> zboruri, List<Client> clientiList)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceți numărul zborului pentru a ii vedea rezervarile:");
        int nrZbor = scanner.nextInt();
        scanner.nextLine();

        boolean ok = true;
        for(Zbor z:zboruri)
        {
            if (z.getNrZbor() == nrZbor) {
                ok = false;
                boolean ok2 = true;
                for (Client cl : clientiList) {
                    Rezervare[] rezervari = cl.getRezervari();
                    if (rezervari != null) {
                        ok2 = false;
                        for (Rezervare rez : rezervari) {
                            if (rez.getZbor().getNrZbor() == nrZbor) {
                                System.out.println(rez);

                            }
                        }
                    }
                }
                if(ok2 == true)
                    System.out.println("Acest zbor nu are rezervari!!");
            }
        }

        if(ok == true)
            System.out.println("Informatii gresite! Incercati din nou!");
    }

    public void searchZborDestinatie(Set<Zbor> zboruri)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceți destinatia zborului:");
        String destinatie = scanner.nextLine().toLowerCase();

        boolean ok=true;
        for(Zbor z:zboruri)
        {
            if(z.getAeroportDestinatie().equals(destinatie)) {
                System.out.println(z);
                ok = false;
            }
        }

        if(ok == true)
            System.out.println("Nu exista zboruri cu aceasta destinatie!");
    }
}
