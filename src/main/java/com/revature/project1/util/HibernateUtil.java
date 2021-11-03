package com.revature.project1.util;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class HibernateUtil {

        private static final SessionFactory g = new Configuration().configure().buildSessionFactory();

        public static Session getSession() {
            return g.openSession();
        }



    }


