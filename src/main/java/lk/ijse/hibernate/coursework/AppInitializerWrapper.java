package lk.ijse.hibernate.coursework;

import lk.ijse.hibernate.coursework.util.SessionFactoryConfig;
import org.hibernate.Session;

public class AppInitializerWrapper {
    public static void main(String[] args) {
        //AppInitializer.main(args)

        Session session = SessionFactoryConfig.getInstance().getSession();

        var transaction = session.beginTransaction();

        transaction.commit();
        session.close();

    }
}
