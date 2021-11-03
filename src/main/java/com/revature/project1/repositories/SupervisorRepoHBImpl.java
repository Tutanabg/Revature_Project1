package com.revature.project1.repositories;


import com.revature.project1.models.BCA;
import com.revature.project1.models.Supervisor;
import com.revature.project1.services.SupervisorService;
import com.revature.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class SupervisorRepoHBImpl implements SupervisorRepo {


    SupervisorRepo su;

    public SupervisorRepoHBImpl(SupervisorRepo su) {

        this.su = su;
    }

    public SupervisorRepoHBImpl() {

    }

    @Override
    public Supervisor addSupervisor(Supervisor s) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(s);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return s;
    }

    @Override
    public Supervisor getSupervisor(int id) {
        Session session = HibernateUtil.getSession();
        Supervisor a = null;

        try {
            a = session.get(Supervisor.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }

    @Override
    public Supervisor updateSupervisor(Supervisor change) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.update(change);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return change;
    }

    @Override
    public Supervisor deleteSupervisor(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Supervisor m = null;

        try {
            tx = session.beginTransaction();
            m = session.get(Supervisor.class, id);
            session.delete(m);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
            return null;
        } finally {
            session.close();
        }

        return m;
    }
}
