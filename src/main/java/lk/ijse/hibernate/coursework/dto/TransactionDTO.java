package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Transaction;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class TransactionDTO implements Serializable {

    private Long id;

    private Date returnDate;
    private Date borrowDate;
    private Date dueDate;
    private int qty;
    private UserDTO user;
    private BookDTO book;

    public Transaction toEntity(){
        Transaction transaction = new Transaction();
        transaction.setId(this.id);
        transaction.setReturnDate(this.returnDate);
        transaction.setBorrowDate(this.borrowDate);
        transaction.setDueDate(this.dueDate);
        transaction.setQty(this.qty);
        if (this.user!=null) {
            transaction.setUser(this.user.toEntity());
        }
        if (this.book!=null) {
            transaction.setBook(this.book.toEntity());
        }
        return transaction;
    }
}
