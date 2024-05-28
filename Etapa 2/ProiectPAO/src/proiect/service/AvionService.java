package proiect.service;

import proiect.domain.Avion;
import proiect.domain.Zbor;

import java.util.Scanner;
import java.util.Set;

public class AvionService {

    public void showAvionZbor(Avion[] avioane, Set<Zbor> zboruri)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceți numarul avionului:");
        int nrAvion = scanner.nextInt();
        scanner.nextLine();

        boolean ok = true;
        for(Avion a:avioane)
        {
            if(a.getNrAvion() == nrAvion)
            {
                ok = false;
                AuditService.logAction("ShowAvionZbor");
                System.out.println("Detalii Avion: " + a);
                System.out.println("Zborurile asociate acestui avion:");

                for (Zbor zbor : zboruri) {
                    if (zbor.getAvion().getNrAvion() ==nrAvion) {
                        System.out.println(zbor);
                    }
                }
            }
        }

        if(ok == true)
            System.out.println("Informatii gresite! Incercati din nou!");
    }
}
