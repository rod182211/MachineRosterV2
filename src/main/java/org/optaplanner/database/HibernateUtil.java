package org.optaplanner.database;


import org.hibernate.SessionFactory;

import org.hibernate.cfg.Configuration;

 
public class HibernateUtil {

   // private static SessionFactory sessionFactory;

	/*
	 * public static boolean setSessionFactory() { try { sessionFactory = new
	 * Configuration() .configure() .buildSessionFactory(); } catch
	 * (HibernateException ex) { return false;
	 * 
	 * }
	 * 
	 * return true; }
	 * 
	 * public static SessionFactory getSessionFactory() { return sessionFactory; }
	 */
    public static final SessionFactory sessionFactory;

    static {
      try {
        // Create the SessionFactory from hibernate.cfg.xml
        Configuration config = new Configuration().configure();
        sessionFactory = config.buildSessionFactory();
      } catch (Throwable ex) {
        // Make sure you log the exception, as it might be swallowed
        System.err.println("Initial SessionFactory creation failed." + ex);
        throw new ExceptionInInitializerError(ex);
      }
    }

public static SessionFactory getSessionFactory() {
	return sessionFactory; }
}