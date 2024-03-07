package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.Transaction;
import lk.ijse.hibernate.coursework.entity.User;

import java.io.Serializable;
import java.util.Date;

public class TransactionDto implements Serializable {

    private Long transactionID;
    private User user;
    private Book book;
    private Date borrowDate;
    private Date returnDate;

}
