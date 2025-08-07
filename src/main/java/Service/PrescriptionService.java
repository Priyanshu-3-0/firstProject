package Service;

import DAO.PrescriptionDAO;
import DAO.AppointmentDAO;
import Entities.Appointment;
import Entities.Prescription;
import java.util.List;

public class PrescriptionService {
    private PrescriptionDAO prescriptionDAO = new PrescriptionDAO();
    private AppointmentDAO appointmentDAO = new AppointmentDAO();

    public void addPrescription(int appointmentId, String diagnosis, String medication, String advice) {
        Appointment appointment = appointmentDAO.getAll().stream()
                .filter(a -> a.getId() == appointmentId)
                .findFirst()
                .orElse(null);

        if (appointment == null) {
            System.out.println("Invalid appointment ID.");
            return;
        }

        Prescription prescription = new Prescription(appointment, diagnosis, medication, advice);
        prescriptionDAO.save(prescription);
        System.out.println("Prescription added successfully.");
    }

    public List<Prescription> getAllPrescriptions() {
        return prescriptionDAO.getAll();
    }
}
