import model.Medikamente;

import java.util.Scanner;

public class Controller {
    private final Service service;

    public Controller(Service service) {
        this.service = service;
    }

    public void alleMedikamenteeAnschreiben(){
        for (Medikamente Medikamente: service.alleMedikamenteeZuruckgeben())
            System.out.println(Medikamente);
    }

    public void createMedikamente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Krankheit");
        String krankheit = sc.nextLine();

        service.createAMedikamente(name, preis, krankheit);
    }

    public void showAMedikamente(){
        System.out.println("Gebe den Namen des Medikamentees ein: ");
        Scanner sc = new Scanner(System.in);
        String name = sc.nextLine();
        Medikamente Medikamente = service.getMedikamente(name);
        System.out.println(Medikamente);
    }

    public void updateMedikamenteValidate(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Medikamentees, das geandert werden soll: ");
        String name = sc.nextLine();
        System.out.println("Preis: ");
        int preis = sc.nextInt();
        sc.nextLine();
        System.out.println("Krankheit: ");
        String krankheit = sc.nextLine();

        service.updateMedikamente(new Medikamente(name, preis, krankheit));
    }

    public void deleteMedikamente(){
        Scanner sc = new Scanner(System.in);
        System.out.println("Name des Medikamentees, das geloescht werden soll: ");
        String name = sc.nextLine();
        service.deleteMedikamente(name);
    }
}
