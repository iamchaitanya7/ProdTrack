package com.jbk.config;

import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;
import com.jbk.entity.Product;

public class HibernateUtil {
    private static SessionFactory sessionFactory;

    public static SessionFactory getSessionFactory () {
        try {
            Configuration configuration = new Configuration ( );
            configuration.configure ("hibernate.cfg.xml");
            configuration.addAnnotatedClass (Product.class);
            sessionFactory = configuration.buildSessionFactory ( );

        } catch (Exception e) {
            e.printStackTrace ( );
        }
        return sessionFactory;
    }
}

