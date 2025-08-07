package DAO;

import Entities.Prescription;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Utility.HibernateUtil;
import java.util.List;

public class PrescriptionDAO {
    public void save(Prescription prescription) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(prescription);
        tx.commit();
        session.close();
    }

    public List<Prescription> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Prescription> list = session.createQuery("from Prescription", Prescription.class).list();
        session.close();
        return list;
    }
}
