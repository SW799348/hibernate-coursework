package lk.ijse.hibernate.coursework.entity;

import javax.persistence.*;
import java.util.Date;
@Entity
@Table(name = "transactions")

public class Transaction {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long transactionID;

    @ManyToOne
    @JoinColumn(name = "userID")
    private User user;

    @ManyToOne
    @JoinColumn(name = "bookID")
    private Book book;

    @Temporal(TemporalType.TIMESTAMP)
    private Date borrowDate;

    @Temporal(TemporalType.TIMESTAMP)
    private Date returnDate;

    private Date DueDate;
    private int qty;

    public Transaction() {
    }

    public Transaction(Long transactionID, User user, Book book, Date borrowDate, Date returnDate, Date dueDate, int qty) {
        this.transactionID = transactionID;
        this.user = user;
        this.book = book;
        this.borrowDate = borrowDate;
        this.returnDate = returnDate;
        DueDate = dueDate;
        this.qty = qty;
    }

    public Long getTransactionID() {
        return transactionID;
    }

    public void setTransactionID(Long transactionID) {
        this.transactionID = transactionID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Book getBook() {
        return book;
    }

    public void setBook(Book book) {
        this.book = book;
    }

    public Date getBorrowDate() {
        return borrowDate;
    }

    public void setBorrowDate(Date borrowDate) {
        this.borrowDate = borrowDate;
    }

    public Date getReturnDate() {
        return returnDate;
    }

    public void setReturnDate(Date returnDate) {
        this.returnDate = returnDate;
    }

    public Date getDueDate() {
        return DueDate;
    }

    public void setDueDate(Date dueDate) {
        DueDate = dueDate;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    @Override
    public String toString() {
        return "Transaction{" +
                "transactionID=" + transactionID +
                ", user=" + user +
                ", book=" + book +
                ", borrowDate=" + borrowDate +
                ", returnDate=" + returnDate +
                ", DueDate=" + DueDate +
                ", qty=" + qty +
                '}';
    }
}
