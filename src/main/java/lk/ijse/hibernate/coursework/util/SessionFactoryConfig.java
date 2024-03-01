package lk.ijse.hibernate.coursework.util;

import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.Branch;
import lk.ijse.hibernate.coursework.entity.Transaction;
import lk.ijse.hibernate.coursework.entity.User;
import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.cfg.Configuration;

public class SessionFactoryConfig {

    private static SessionFactoryConfig factoryConfig;

    private static SessionFactory sessionFactory ;

    private SessionFactoryConfig(){
        sessionFactory=new Configuration().mergeProperties(Utility.getProperties())
                .addAnnotatedClass(Transaction.class)
                .addAnnotatedClass(User.class)
                .addAnnotatedClass(Book.class)
                .addAnnotatedClass(Branch.class)
                .buildSessionFactory();
    }

    public static SessionFactoryConfig getInstance(){
        return (factoryConfig==null) ?  factoryConfig=new SessionFactoryConfig() : factoryConfig;
    }

    public Session getSession() throws HibernateException {
         return sessionFactory.openSession();
    }

}
