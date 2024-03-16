package lk.ijse.hibernate.coursework.repository.impl;

import lk.ijse.hibernate.coursework.entity.User;
import lk.ijse.hibernate.coursework.repository.inter.UserRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class UserRepositoryImpl implements UserRepository {

    private Session session;
    private static UserRepositoryImpl userRepositoryImpl;

    private UserRepositoryImpl(){}

    public static UserRepositoryImpl getInstance(){
        return null==userRepositoryImpl
                ?userRepositoryImpl=new UserRepositoryImpl()
                :userRepositoryImpl;
    }
    @Override
    public void setSession(Session session) {
        this.session = session;
    }
    @Override
    public Long save(User object) {
        return (Long) session.save(object);
    }

    @Override
    public void update(User object) {
        session.update(object);
    }

    @Override
    public User get(Long aLong) {
        return session.get(User.class, aLong);
    }

    @Override
    public void delete(User object) {
        session.delete(object);

    }

    @Override
    public List<User> getAll(){
        String sqlQuery = "FROM User ";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();

        session.close();
        return list;
    }




}
