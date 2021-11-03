package com.revature.project1.repositories;

import com.revature.project1.models.BCA;
import com.revature.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class BCARepoHBImpl implements BCARepo{


    @Override
    public BCA addBCA(BCA a) {

        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(a);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return a;

    }

    @Override
    public BCA getBCA(int id) {
        Session session = HibernateUtil.getSession();
        BCA a = null;

        try {
            a = session.get(BCA.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;


    }

    @Override
    public BCA updateBCA(BCA change) {
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
    public BCA deleteBCA(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        BCA m = null;

        try {
            tx = session.beginTransaction();
            m = session.get(BCA.class, id);
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
