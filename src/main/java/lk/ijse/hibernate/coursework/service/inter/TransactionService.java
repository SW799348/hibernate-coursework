package lk.ijse.hibernate.coursework.service.inter;

import lk.ijse.hibernate.coursework.dto.TransactionDTO;
import lk.ijse.hibernate.coursework.service.SuperService;

import java.util.List;

public interface TransactionService  extends SuperService {

    Long saveTransaction(TransactionDTO transactionDTO);

    TransactionDTO getTransaction(long id);

    boolean updateTransaction(TransactionDTO transactionDTO);

    boolean deleteTransaction(TransactionDTO transactionDTO);

    List<TransactionDTO> getAllTransactions();
}
