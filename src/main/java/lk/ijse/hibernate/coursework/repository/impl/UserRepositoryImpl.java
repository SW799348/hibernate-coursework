package lk.ijse.hibernate.coursework.repository.impl;

import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.repository.inter.UserRepository;
import org.hibernate.Session;

import java.util.ArrayList;

public class UserRepositoryImpl implements UserRepository {

    private Session session;

    private static UserRepositoryImpl userRepository;
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
    public ArrayList<User> getAll() {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }
}
