package lk.ijse.hibernate.coursework.repository;

import org.hibernate.Session;

public interface SuperRepository {
    void setSession(Session session);
}
