package lk.ijse.hibernate.coursework.repository.impl;

import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.repository.inter.AdminRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class AdminRepositoryImpl implements AdminRepository {

    private static AdminRepositoryImpl adminRepositoryImpl;
    private Session session;

    private AdminRepositoryImpl() {

    }

    public static AdminRepositoryImpl getInstance() {
        return null == adminRepositoryImpl
                ? adminRepositoryImpl = new AdminRepositoryImpl()
                : adminRepositoryImpl;
    }

    @Override
    public void setSession(Session session) {
        this.session = session;
    }

    @Override
    public Long save(Admin admin) {

        return (Long) session.save(admin);
    }

    @Override
    public void update(Admin admin) {
        session.update(admin);
    }

    @Override
    public Admin get(Long id) {

        return session.get(Admin.class, id);
    }

    @Override
    public void delete(Admin admin) {
        session.delete(admin);
    }

    @Override
    public List<Admin> getAll() {
        String sqlQuery = "FROM Admin";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();

        session.close();
        return list;

    }
}
