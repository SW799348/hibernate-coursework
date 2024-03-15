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
        return null==transactionRepositoryImpl?transactionRepositoryImpl=new TransactionRepositoryImpl():transactionRepositoryImpl;
    }
    @Override
    public Long save(Transaction transaction) {
        return (Long) session.save(transaction);
    }

    @Override
    public void update(Transaction transaction) {
      session.update(transaction);
    }

    @Override
    public Transaction get(Long id) {
        return session.get(Transaction.class,id);
    }

    @Override
    public void delete(Transaction transaction) {
session.delete(transaction);
    }

    @Override
    public List<Transaction> getAll() {
        String sql="FROM Transaction";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }

    @Override
    public void setSession(Session session) {
     this.session=session;
    }
}
