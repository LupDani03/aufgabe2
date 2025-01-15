import model.Medikamente;

import java.util.List;

public class Service {

    private Repository<Medikamente> MedikamenteRepository;

    public Service(Repository<Medikamente> MedikamenteRepository) {
        this.MedikamenteRepository = MedikamenteRepository;
    }

    public List<Medikamente> alleMedikamenteeZuruckgeben() {
        return MedikamenteRepository.getAllElements();
    }

    public void createAMedikamente(String name, int preis, String jahreszeit) {
        MedikamenteRepository.addElement(new Medikamente(name, preis, jahreszeit));
    }

    public Medikamente getMedikamente(String name) {
        int id = -1;
        for (Medikamente p : MedikamenteRepository.getAllElements()) {
            if (p.getName().equals(name)) {
                id = MedikamenteRepository.getAllElements().indexOf(p);
                break;
            }
        }
        return MedikamenteRepository.getElement(id);
    }

    public void updateMedikamente(Medikamente Medikamente) {
        for (Medikamente p : MedikamenteRepository.getAllElements()) {
            if (p.getName().equals(Medikamente.getName())) {
                int index = MedikamenteRepository.getAllElements().indexOf(p);
                p.setPreis(Medikamente.getPreis());
                p.setKrankheit(Medikamente.getKrankheit());
                MedikamenteRepository.updateElement(index, Medikamente);
                break;
            }
        }
    }

    public void deleteMedikamente(String name) {
        for (Medikamente p : MedikamenteRepository.getAllElements()) {
            if (p.getName().equals(name)) {
                MedikamenteRepository.remove(p);
                break;
            }
        }
    }
}
