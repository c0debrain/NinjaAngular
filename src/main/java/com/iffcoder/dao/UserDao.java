package com.iffcoder.dao;

import com.iffcoder.models.User;
import hibernate.HibernateUtil;
import ninja.jpa.UnitOfWork;
import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.transaction.Transactional;
import java.util.List;


import org.hibernate.*;
import org.hibernate.criterion.Restrictions;

import javax.transaction.Transactional;
import java.util.List;

/**
 * Created by guoliangwang on 10/27/14.
 */

public class UserDao
{
    private final static SessionFactory sessionFactory = HibernateUtil.getSessionFactory();

    public UserDao() {}
    public List<User> findAllUsers()
    {
        List<User> users = null;
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        users = criteria.list();

        session.close();

        return users;
    }

    @Transactional
    public void saveUser(User user)
    {
        Session session = sessionFactory.openSession();
        Transaction tx = session.beginTransaction();

        if (user.getUserProfile() != null) {

            //    session.save(user.getUserProfile());
        } else {
            System.out.println("profile is null!");
        }
        session.save(user);


        tx.commit();

        session.close();
    }

    @UnitOfWork
    public User findUserByEmail(String email)
    {
        User user = null;
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("email", email));
        user = (User) criteria.uniqueResult();

        session.close();
        return user;
    }

    @UnitOfWork
    public User findUserById(Long id)
    {
        User user = null;
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("id", id));
        user = (User) criteria.uniqueResult();

        session.close();
        return user;
    }

    /*
    public User findUserByUsername(String username)
    {
        User user = null;
        Session session = sessionFactory.openSession();
        Criteria criteria = session.createCriteria(User.class);
        criteria.add(Restrictions.eq("username", username));
        user = (User) criteria.uniqueResult();

        session.close();
        return user;
    }
    */

    @Transactional
    public void deleteUser(User user)
    {
        Session session = null;
        try {
            session = sessionFactory.openSession();
            Transaction tx = session.beginTransaction();

            session.delete(user);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }
    }

    @Transactional
    public void deleteUserById(Long id) {
        User user = findUserById(id);
        if (user != null) {
            deleteUser(user);
        }
    }

}
