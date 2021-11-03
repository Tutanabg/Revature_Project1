package com.revature.project1.repositories;

import com.revature.project1.models.BCA;
import com.revature.project1.models.Department;
import com.revature.project1.util.HibernateUtil;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.Transaction;


public class DepartmentRepoHBImpl implements DepartmentRepo {

//    DepartmentRepo d;
//
//    public DepartmentRepoHBImpl(DepartmentRepo d) {
//
//        this.d = d;
//    }
//
//    public DepartmentRepoHBImpl() {
//
//    }

    @Override
    public Department addDepartment(Department dh) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;

        try {
            tx = session.beginTransaction();
            session.persist(dh);
            tx.commit();
        } catch (HibernateException e) {
            e.printStackTrace();
            if(tx != null) tx.rollback();
        } finally {
            session.close();
        }

        return dh;
    }

    @Override
    public Department getDepartment(int id) {
        Session session = HibernateUtil.getSession();
        Department a = null;

        try {
            a = session.get(Department.class, id);

        } catch (HibernateException e) {
            e.printStackTrace();
        } finally {
            session.close();
        }

        return a;

    }

    @Override
    public Department updateDepartment(Department change) {
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
    public Department deleteDepartment(int id) {
        Session session = HibernateUtil.getSession();
        Transaction tx = null;
        Department m = null;

        try {
            tx = session.beginTransaction();
            m = session.get(Department.class, id);
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

