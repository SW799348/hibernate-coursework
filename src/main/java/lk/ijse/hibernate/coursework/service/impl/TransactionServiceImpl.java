package lk.ijse.hibernate.coursework.service.impl;

import lk.ijse.hibernate.coursework.dto.TransactionDto;
import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.service.inter.TransactionService;

import java.util.List;

public class TransactionServiceImpl implements TransactionService {

    @Override
    public Long saveTransaction(TransactionDto transactionDto) {
        return null;
    }

    @Override
    public TransactionDto getTransaction(long id) {
        return null;
    }

    @Override
    public boolean updateTransaction(TransactionDto transactionDto) {
        return false;
    }

    @Override
    public boolean deleteTransaction(TransactionDto transactionDto) {
        return false;
    }

    @Override
    public List<TransactionDto> getAllTransactions() {
        return null;
    }
}
