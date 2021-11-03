package com.revature.project1.repositories;


import com.revature.project1.models.BCA;
import com.revature.project1.models.DepartmentHead;
import com.revature.project1.services.DepartmentHeadService;
import com.revature.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;

public class DepartmentHeadRepoHBImpl implements DepartmentHeadRepo {

    DepartmentHeadRepo dh;

    public DepartmentHeadRepoHBImpl(DepartmentHeadRepo dh) {

        this.dh = dh;
    }

    public DepartmentHeadRepoHBImpl() {

    }

    @Override
    public DepartmentHead addDepartmentHead(DepartmentHead dh) {

        try (Session session = HibernateUtil.getSession()) {
            Transaction tx = null;
            tx = session.beginTransaction();
            session.persist(dh);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
//            if (tx != null) tx.rollback();
        }

        return dh;
    }

    @Override
    public DepartmentHead getDepartmentHead(int id) {
        Session session = HibernateUtil.getSession();
        DepartmentHead a = null;

        try {
            a = session.get(DepartmentHead.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;
    }

    @Override
    public DepartmentHead updateDepartmentHead(DepartmentHead change) {
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
    public DepartmentHead deleteDepartmentHead(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        DepartmentHead m = null;

        try {
            tx = session.beginTransaction();
            m = session.get(DepartmentHead.class, id);
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
