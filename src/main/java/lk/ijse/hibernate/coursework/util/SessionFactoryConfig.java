package lk.ijse.hibernate.coursework.util;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private final SessionFactory sessionFactory ;

    private SessionFactoryConfig(){
        sessionFactory=new Configuration().mergeProperties(Utility.getProperties()).addAnnotatedClass().buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return (factoryConfig==null) ?  factoryConfig=new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession() throws HibernateException {
         return sessionFactory.openSession();
    }

}
