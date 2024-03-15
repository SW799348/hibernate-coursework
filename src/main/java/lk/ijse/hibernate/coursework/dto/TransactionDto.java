package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.Transaction;
import lk.ijse.hibernate.coursework.entity.User;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TransactionDto implements Serializable {

    private Long transactionID;
    private UserDto user;
    private BookDto book;
    private Date borrowDate;
    private Date returnDate;
    private Date DueDate;


    public Transaction toEntity(){
        Transaction transactionEntity = new Transaction();

        transactionEntity.setTransactionID(this.transactionID);
        transactionEntity.setBorrowDate(this.borrowDate);
        transactionEntity.setReturnDate(this.returnDate);
        transactionEntity.setDueDate(this.DueDate);

        if(user!=null){
            transactionEntity.setUser(user.toEntity());
        }


        if(book!=null){
            transactionEntity.setBook(book.toEntity());
        }



        return transactionEntity;

    }
}
