package lk.ijse.hibernate.coursework.repository.impl;

import lk.ijse.hibernate.coursework.entity.Transaction;
import lk.ijse.hibernate.coursework.repository.inter.TransactionRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {

    private Session session;
    private static TransactionRepositoryImpl transactionRepositoryImpl;
    private TransactionRepositoryImpl(){}

    public static TransactionRepositoryImpl getInstance(){
        return null==transactionRepositoryImpl
                ?transactionRepositoryImpl=new TransactionRepositoryImpl()
                :transactionRepositoryImpl;
    }
    @Override
    public void setSession(Session session) {
        this.session = session;
    }
    @Override
    public Long save(Transaction object) {
        return (Long) session.save(object);
    }

    @Override
    public void update(Transaction object) {
        session.update(object);

    }

    @Override
    public Transaction get(Long aLong) {
        return session.get(Transaction.class, aLong);
    }

    @Override
    public void delete(Transaction object) {
        session.delete(object);
    }

    @Override
    public List<Transaction> getAll() {
        String sqlQuery = "FROM Transaction ";
        Query query = session.createQuery(sqlQuery);
        List list = query.list();

        session.close();
        return list;
    }


}
