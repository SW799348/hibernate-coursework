package lk.ijse.hibernate.coursework.service.impl;

import lk.ijse.hibernate.coursework.dto.TransactionDto;
import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.repository.impl.TransactionRepositoryImpl;
import lk.ijse.hibernate.coursework.repository.inter.TransactionRepository;
import lk.ijse.hibernate.coursework.service.inter.TransactionService;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    private Session session;

    private static TransactionService transactionService;

    private final TransactionRepository transactionRepository;

    private TransactionServiceImpl(){
        transactionRepository= TransactionRepositoryImpl.getInstance();
    }

    public static TransactionService getInstance(){
        return null==transactionService?transactionService=new TransactionServiceImpl():transactionService;
    }

    @Override
    public Long saveTransaction(TransactionDto transactionDto) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            transactionRepository.setSession(session);
            Long id = transactionRepository.save(transactionDto.toEntity());
            transaction.commit();
            session.close();
            return id;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return -1L;
        }
    }

    @Override
    public TransactionDto getTransaction(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            transactionRepository.setSession(session);
            lk.ijse.hibernate.coursework.entity.Transaction transaction = transactionRepository.get(id);
            session.close();
            return transaction.toDto();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean updateTransaction(TransactionDto transactionDto) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            transactionRepository.setSession(session);
            transactionRepository.update(transactionDto.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteTransaction(TransactionDto transactionDto) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            transactionRepository.setSession(session);
            transactionRepository.delete(transactionDto.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        transactionRepository.setSession(session);
        List<lk.ijse.hibernate.coursework.entity.Transaction> allTransactions = transactionRepository.getAll();
        List<TransactionDto> transactionDtoList = new ArrayList<>();
        for (lk.ijse.hibernate.coursework.entity.Transaction transaction : allTransactions) {
            transactionDtoList.add(transaction.toDto()); // We convert the Entity back to a dto type before return to the controller
        }
        return transactionDtoList;
    }
}
