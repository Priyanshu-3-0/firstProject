package Entities;

import jakarta.persistence.*;

@Entity
public class Prescription {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @OneToOne
    private Appointment appointment;

    private String diagnosis;
    private String medication;
    private String advice;

    public Prescription() {}

    public Prescription(Appointment appointment, String diagnosis, String medication, String advice) {
        this.appointment = appointment;
        this.diagnosis = diagnosis;
        this.medication = medication;
        this.advice = advice;
    }

    // Getters and Setters
    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
    }
    public Appointment getAppointment() {
        return appointment;
    }
    public void setAppointment(Appointment appointment) {
        this.appointment = appointment;
    }
    public String getDiagnosis() {
        return diagnosis;
    }
    public void setDiagnosis(String diagnosis) {
        this.diagnosis = diagnosis;
    }
    public String getMedication() {
        return medication;
    }
    public void setMedication(String medication) {
        this.medication = medication;
    }
    public String getAdvice() {
        return advice;
    }
    public void setAdvice(String advice) {
        this.advice = advice;
    }
}
