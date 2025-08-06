package Entities;

import jakarta.persistence.*;
import java.time.LocalDateTime;

@Entity
public class Appointment {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @ManyToOne
    private User patient;

    @ManyToOne
    private User doctor;

    private LocalDateTime appointmentDateTime;
    private String status;

    @OneToOne(mappedBy = "appointment", cascade = CascadeType.ALL)
    private Prescription prescription;

    public Appointment() {}

    public Appointment(User patient, User doctor, LocalDateTime dateTime, String status) {
        this.patient = patient;
        this.doctor = doctor;
        this.appointmentDateTime = dateTime;
        this.status = status;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public User getPatient() {
        return patient;
    }
    public void setPatient(User patient) {
        this.patient = patient;
    }
    public User getDoctor() {
        return doctor;
    }
    public void setDoctor(User doctor) {
        this.doctor = doctor;
    }
    public LocalDateTime getAppointmentDateTime() {
        return appointmentDateTime;
    }
    public void setAppointmentDateTime(LocalDateTime appointmentDateTime) {
        this.appointmentDateTime = appointmentDateTime;
    }
    public String getStatus() {
        return status;
    }
    public void setStatus(String status) {
        this.status = status;
    }
    public Prescription getPrescription() {
        return prescription;
    }
    public void setPrescription(Prescription prescription) {
        this.prescription = prescription;
    }
}
