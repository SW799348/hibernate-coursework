package lk.ijse.hibernate.coursework.repository.impl;

import lk.ijse.hibernate.coursework.entity.Transaction;
import lk.ijse.hibernate.coursework.repository.inter.TransactionRepository;
import org.hibernate.Session;

import java.util.ArrayList;
import java.util.List;

public class TransactionRepositoryImpl implements TransactionRepository {

    private Session session;
    private static TransactionRepositoryImpl transactionRepositoryImpl;

    private TransactionRepositoryImpl(){}
    @Override
    public Long save(Transaction object) {
        return null;
    }

    @Override
    public void update(Transaction object) {

    }

    @Override
    public Transaction get(Long aLong) {
        return null;
    }

    @Override
    public void delete(Transaction object) {

    }

    @Override
    public List<Transaction> getAll() {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }
}
