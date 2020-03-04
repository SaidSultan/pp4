package com.said.dao;

import com.said.model.User;
import com.said.util.DBHelper;
import com.said.util.HiberDBHelper;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.hibernate.query.Query;


import java.util.List;

public class UserHibernateDAO implements UserDAO {
    private SessionFactory sessionFactory;
    private Session session;
    public UserHibernateDAO() {
        sessionFactory = DBHelper.getDBHelper().getConfiguration();
    }
    @Override
    public void addUser(User user) {
        session = sessionFactory.openSession();
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            session.save(user);
            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.out.println("Error while add user");
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void updateUser(User user) {
        session = sessionFactory.openSession();
        String hql = "update User SET name = :name, lastName  = :lastName, age = :age  where id = :idParam";
        Transaction transaction = null;
        try {
            transaction = session.beginTransaction();
            Query query = session.createQuery(hql);

            query.setParameter("idParam", user.getId());
            query.setParameter("name", user.getName());
            query.setParameter("lastName", user.getLastName());
            query.setParameter("age", user.getAge());
            query.executeUpdate();

            transaction.commit();
        } catch (HibernateException ex) {
            transaction.rollback();
            System.out.println("Error while update user");
            ex.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Override
    public void deleteUSer(long id) {
        session = sessionFactory.openSession();
        String hql = "DELETE User WHERE id = :id";
        Transaction transaction = session.beginTransaction();
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        session.close();
    }

    @Override
    public User getUserById(long id) {
        session = sessionFactory.openSession();
      //User user = (User) session.load(User.class, id);
      User user = (User) session.get(User.class, id);
      session.detach(user);
      session.close();
/*        String hql = "FROM User where id = :id";
        Query query = session.createQuery(hql);
        query.setParameter("id", id);
        List<User> list = query.list();
        User user = list.get(0);*/
        return user;
    }

    @Override
    public List<User> getAllUsers() {
        session = sessionFactory.openSession();
        String hql = "FROM User";
        Query query = session.createQuery(hql);
        List<User> users = query.list();
        session.close();
        return users;
    }
}
