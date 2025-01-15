import model.Patienten;
import model.Medikamente;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Console {

    private Controller controller;

    public Console(Controller controller) {
        this.controller = controller;
    }
    public Console() {}

    public void setController(Controller controller) {this.controller = controller;}

    public void run() {
        Scanner sc = new Scanner(System.in);
        int option = -1;
        while (option != 0)
        {
            System.out.println("""
                    1. Medikamenten CRUD
                    0. Exit""");

            option = sc.nextInt();
            sc.nextLine();

            switch (option) {
                case 1: {
                    System.out.println("""
                            1. Neues Medikament hinzufugen
                            2. Alle Medikamente sehen
                            3. Ein bestimmtes Medikament finden
                            4. Ein Medikament aktualisieren
                            5. Ein Medikament loschen
                            0. Exit""");
                    int crudOption = sc.nextInt();
                    sc.nextLine();
                    switch (crudOption) {
                        case 1: {controller.createMedikamente(); break;}
                        case 2: {controller.alleMedikamenteeAnschreiben(); break;}
                        case 3: {controller.showAMedikamente(); break;}
                        case 4: {controller.updateMedikamenteValidate(); break;}
                        case 5: {controller.deleteMedikamente(); break;}
                        case 0:break;
                    }
                }

                case 0: break;
            }
        }

    }

    public static void main(String[] args) {

        Repository<Medikamente> MedikamenteRepository = new Repository<>();
//        Repository<Kunde> kundeRepository = new Repository<>();

        Console console = new Console();
        console.initialiseData(MedikamenteRepository);

        Service service = new Service(MedikamenteRepository);
        Controller controller = new Controller(service);

        console = new Console(controller);
        console.run();
    }

    public void initialiseData(Repository<Medikamente> MedikamenteRepository) {
        Medikamente Medikamente1 = new Medikamente("Paracetamol",40,"Kopfschmerzen");
        Medikamente Medikamente2 = new Medikamente("Nurofen",30,"Kopfschmerzen");
        Medikamente Medikamente3 = new Medikamente("Advil",20,"Migraine");
        Medikamente Medikamente4 = new Medikamente("Strepsils",27,"Husten");

        MedikamenteRepository.addElement(Medikamente1);
        MedikamenteRepository.addElement(Medikamente2);
        MedikamenteRepository.addElement(Medikamente3);
        MedikamenteRepository.addElement(Medikamente4);
    }
}
