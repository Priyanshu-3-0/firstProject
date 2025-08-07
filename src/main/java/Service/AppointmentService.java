package Service;

import DAO.AppointmentDAO;
import DAO.UserDAO;
import Entities.Appointment;
import Entities.User;
import java.time.LocalDateTime;
import java.util.List;

public class AppointmentService {
    private AppointmentDAO appointmentDAO = new AppointmentDAO();
    private UserDAO userDAO = new UserDAO();

    public void bookAppointment(int patientId, int doctorId, LocalDateTime dateTime) {
        User patient = userDAO.getById(patientId);
        User doctor = userDAO.getById(doctorId);

        if (patient == null || doctor == null) {
            System.out.println("Invalid patient or doctor ID.");
            return;
        }

        if (!"PATIENT".equalsIgnoreCase(patient.getRole()) || !"DOCTOR".equalsIgnoreCase(doctor.getRole())) {
            System.out.println("Role mismatch.");
            return;
        }

        if (appointmentDAO.isDoctorBusy(doctorId, dateTime)) {
            System.out.println("Doctor already has an appointment at that time.");
            return;
        }

        Appointment appt = new Appointment(patient, doctor, dateTime, "Scheduled");
        appointmentDAO.save(appt);
        System.out.println("Appointment booked successfully.");
    }

    public List<Appointment> getAllAppointments() {
        return appointmentDAO.getAll();
    }
}
