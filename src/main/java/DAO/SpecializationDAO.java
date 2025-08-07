package DAO;

import Entities.Specialization;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Utility.HibernateUtil;
import java.util.List;

public class SpecializationDAO {
    public void save(Specialization specialization) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(specialization);
        tx.commit();
        session.close();
    }

    public Specialization getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Specialization sp = session.get(Specialization.class, id);
        session.close();
        return sp;
    }

    public List<Specialization> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<Specialization> list = session.createQuery("from Specialization", Specialization.class).list();
        session.close();
        return list;
    }
}
