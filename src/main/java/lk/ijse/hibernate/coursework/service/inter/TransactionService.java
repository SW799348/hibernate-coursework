package lk.ijse.hibernate.coursework.service.inter;

import lk.ijse.hibernate.coursework.dto.TransactionDto;
import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.service.SuperService;

import java.util.List;

public interface TransactionService  extends SuperService {

    Long saveTransaction(TransactionDto transactionDto);
    TransactionDto getTransaction(long id);
    boolean updateTransaction(TransactionDto transactionDto);
    boolean deleteTransaction(TransactionDto transactionDto);
    List<TransactionDto> getAllTransactions();
}
