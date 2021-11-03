package com.revature.project1.repositories;

import com.revature.project1.models.Request;
import com.revature.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;
import org.hibernate.criterion.CriteriaQuery;
import org.hibernate.criterion.Restrictions;


import java.util.List;


public class RequestRepoHBImpl implements RequestRepo {

    RequestRepo r;

    public RequestRepoHBImpl(RequestRepo r) {

        this.r = r;
    }

    public RequestRepoHBImpl() {

    }

    @Override
    public Request addRequest(Request rq) {

        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(rq);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return rq;
    }

    @Override
    public Request getRequest(int id) {
        Session session = HibernateUtil.getSession();
        Request a = null;

        try {
            a = session.get(Request.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }

    @Override
    public List<Request> getAllRequest() {
        Session session = HibernateUtil.getSession();
        List requests = null;

        try {
            requests = session.createQuery("FROM Request ").list();
        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return requests;

    }

    @Override
    public Request updateRequest(Request change) {
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
    public Request deleteRequest(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Request m = null;

        try {
            tx = session.beginTransaction();
            m = session.get(Request.class, id);
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
