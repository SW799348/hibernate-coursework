package lk.ijse.hibernate.coursework.repository.impl;

import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.repository.inter.UserRepository;
import org.hibernate.Session;

public class UserRepositoryImpl implements UserRepository {
    @Override
    public Long save(User object) {
        return null;
    }

    @Override
    public void update(User object) {

    }

    @Override
    public User get(Long aLong) {
        return null;
    }

    @Override
    public void delete(User object) {

    }

    @Override
    public void setSession(Session session) {

    }
}
