package Service;

import DAO.SpecializationDAO;
import Entities.Specialization;
import java.util.List;

public class SpecializationService {
    private SpecializationDAO specializationDAO = new SpecializationDAO();

    public int addSpecialization(String name) {
        Specialization specialization = new Specialization(name);
        specializationDAO.save(specialization);
        return specialization.getId();
    }

    public List<Specialization> getAllSpecializations() {
        return specializationDAO.getAll();
    }
}
