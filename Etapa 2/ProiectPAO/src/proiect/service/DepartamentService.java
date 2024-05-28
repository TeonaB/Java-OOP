package proiect.service;

import proiect.domain.Departament;
import proiect.domain.SefDepartament;

import java.util.Objects;
import java.util.Scanner;

public class DepartamentService {

    public void showDepartAngajati(Departament[] departamente, SefDepartament[] sefi)
    {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Introduceți numele departamentului:");
        String departament = formatareNume(scanner.nextLine());

        boolean ok=true;
        for(Departament d:departamente)
        {
            if(d.getNume().equals(departament))
            {
                ok=false;
                AuditService.logAction("ShowDepartAngajati");
                System.out.println(d);
                for(SefDepartament sef:sefi)
                {
                    if(Objects.equals(sef.getDepartament().getNume(), departament))
                    {
                        System.out.println("Seful departamentului este:");
                        System.out.println(sef);
                    }
                }
            }
        }

        if(ok == true)
        {
            System.out.println("Informatii gresite! Incercati din nou!");
        }
    }

    public static String formatareNume(String input) {
        if (input == null || input.isEmpty()) {
            return input;
        }
        String firstLetter = input.substring(0, 1).toUpperCase();
        String restOfString = input.substring(1).toLowerCase();
        return firstLetter + restOfString;
    }
}
