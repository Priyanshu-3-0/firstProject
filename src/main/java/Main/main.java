package Main;

import Service.*;
import Entities.*;
import java.time.LocalDateTime;
import java.util.Scanner;
public class main {
    public static void main(String[] args) {
        SpecializationService specializationService = new SpecializationService();
        UserService userService = new UserService();
        AppointmentService appointmentService = new AppointmentService();
        PrescriptionService prescriptionService = new PrescriptionService();
        Scanner sc = new Scanner(System.in);

        while (true) {
            System.out.println("\n=== Healthcare System Menu ===");
            System.out.println("1. Add Specialization");
            System.out.println("2. Add Doctor");
            System.out.println("3. Add Patient");
            System.out.println("4. Book Appointment");
            System.out.println("5. Add Prescription");
            System.out.println("6. View All Appointments");
            System.out.println("7. View All Prescriptions");
            System.out.println("0. Exit");
            System.out.print("Enter choice: ");
            int choice = sc.nextInt();
            sc.nextLine();

            switch (choice) {
                case 1:
                    System.out.print("Enter specialization name: ");
                    String spName = sc.nextLine();
                    int spId = specializationService.addSpecialization(spName);
                    System.out.println("Specialization added with ID: " + spId);
                    break;
                case 2:
                    System.out.print("Enter doctor name: ");
                    String docName = sc.nextLine();
                    System.out.print("Enter email: ");
                    String docEmail = sc.nextLine();
                    System.out.print("Enter specialization ID: ");
                    int docSpId = sc.nextInt();
                    sc.nextLine();
                    int docId = userService.createUser(docName, docEmail, "DOCTOR", docSpId);
                    System.out.println("Doctor added with ID: " + docId);
                    break;
                case 3:
                    System.out.print("Enter patient name: ");
                    String patName = sc.nextLine();
                    System.out.print("Enter email: ");
                    String patEmail = sc.nextLine();
                    int patId = userService.createUser(patName, patEmail, "PATIENT", null);
                    System.out.println("Patient added with ID: " + patId);
                    break;
                case 4:
                    System.out.print("Enter patient ID: ");
                    int pId = sc.nextInt();
                    System.out.print("Enter doctor ID: ");
                    int dId = sc.nextInt();
                    System.out.print("Enter year month day hour minute (space separated): ");
                    int y = sc.nextInt(), m = sc.nextInt(), day = sc.nextInt(), hr = sc.nextInt(), min = sc.nextInt();
                    sc.nextLine();
                    appointmentService.bookAppointment(pId, dId, LocalDateTime.of(y, m, day, hr, min));
                    break;
                case 5:
                    System.out.print("Enter appointment ID: ");
                    int apptId = sc.nextInt();
                    sc.nextLine();
                    System.out.print("Enter diagnosis: ");
                    String diag = sc.nextLine();
                    System.out.print("Enter medication: ");
                    String med = sc.nextLine();
                    System.out.print("Enter advice: ");
                    String adv = sc.nextLine();
                    prescriptionService.addPrescription(apptId, diag, med, adv);
                    break;
                case 6:
                    for (Appointment a : appointmentService.getAllAppointments()) {
                        System.out.println(a.getId() + " | Patient: " + a.getPatient().getName() +
                                " | Doctor: " + a.getDoctor().getName() +
                                " | Date: " + a.getAppointmentDateTime() +
                                " | Status: " + a.getStatus());
                    }
                    break;
                case 7:
                    for (Prescription p : prescriptionService.getAllPrescriptions()) {
                        System.out.println(p.getId() + " | Appointment ID: " + p.getAppointment().getId() +
                                " | Diagnosis: " + p.getDiagnosis() +
                                " | Medication: " + p.getMedication() +
                                " | Advice: " + p.getAdvice());
                    }
                    break;
                case 0:
                    System.out.println("Exiting...");
                    sc.close();
                    return;
                default:
                    System.out.println("Invalid choice.");
            }
        }
    }
}

