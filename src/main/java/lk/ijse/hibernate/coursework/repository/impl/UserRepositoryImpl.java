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
        return null==userRepositoryImpl?userRepositoryImpl=new UserRepositoryImpl():userRepositoryImpl;
    }
    @Override
    public Long save(User user) {
        return (Long) session.save(user);
    }

    @Override
    public void update(User user) {
      session.update(user);
    }

    @Override
    public User get(Long id) {
        return session.get(User.class,id);
    }

    @Override
    public void delete(User user) {
      session.delete(user);
    }

    @Override
    public List<User> getAll() {
        String sqlQuery="FROM User";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public void setSession(Session session) {
           this.session=session;
    }



}
