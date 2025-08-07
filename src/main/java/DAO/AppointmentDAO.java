package DAO;

import Entities.Appointment;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Utility.HibernateUtil;
import java.time.LocalDateTime;
import java.util.List;

public class AppointmentDAO {
    public void save(Appointment appointment) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(appointment);
        tx.commit();
        session.close();
    }

    public List<Appointment> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Appointment> list = session.createQuery("from Appointment", Appointment.class).list();
        session.close();
        return list;
    }

    public boolean isDoctorBusy(int doctorId, LocalDateTime dateTime) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Long count = session.createQuery(
                        "select count(a) from Appointment a where a.doctor.id = :docId and a.appointmentDateTime = :dt",
                        Long.class
                ).setParameter("docId", doctorId)
                .setParameter("dt", dateTime)
                .uniqueResult();
        session.close();
        return count != null && count > 0;
    }
}
