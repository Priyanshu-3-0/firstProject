package DAO;

import Entities.User;
import org.hibernate.Session;
import org.hibernate.Transaction;
import Utility.HibernateUtil;
import java.util.List;

public class UserDAO {

    public void save(User user) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        Transaction tx = session.beginTransaction();
        session.save(user);
        tx.commit();
        session.close();
    }

    public User getById(int id) {
        Session session = HibernateUtil.getSessionFactory().openSession();
        User user = session.get(User.class, id);
        session.close();
        return user;
    }

    public List<User> getAll() {
        Session session = HibernateUtil.getSessionFactory().openSession();
        List<User> list = session.createQuery("from User", User.class).list();
        session.close();
        return list;
    }
}
