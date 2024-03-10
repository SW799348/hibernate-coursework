package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.Branch;
import lk.ijse.hibernate.coursework.entity.Transaction;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class BookDto implements Serializable {

    private Long bookID;
    private String title;
    private String author;
    private String genre;
    private boolean availabilityStatus;
    private int qty;

    private Admin admin;
    private List<TransactionDto> transactionList;
    private Branch branch;

    public BookDto() {
    }

    public BookDto(Long bookID, String title, String author, String genre, boolean availabilityStatus, int qty, Admin admin, List<TransactionDto> transactionList, Branch branch) {
        this.bookID = bookID;
        this.title = title;
        this.author = author;
        this.genre = genre;
        this.availabilityStatus = availabilityStatus;
        this.qty = qty;
        this.admin = admin;
        this.transactionList = transactionList;
        this.branch = branch;
    }

    public Long getBookID() {
        return bookID;
    }

    public void setBookID(Long bookID) {
        this.bookID = bookID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public boolean isAvailabilityStatus() {
        return availabilityStatus;
    }

    public void setAvailabilityStatus(boolean availabilityStatus) {
        this.availabilityStatus = availabilityStatus;
    }

    public int getQty() {
        return qty;
    }

    public void setQty(int qty) {
        this.qty = qty;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<TransactionDto> getTransactionList() {
        return transactionList;
    }

    public void setTransactionList(List<TransactionDto> transactionList) {
        this.transactionList = transactionList;
    }

    public Branch getBranch() {
        return branch;
    }

    public void setBranch(Branch branch) {
        this.branch = branch;
    }

    @Override
    public String toString() {
        return "BookDto{" +
                "bookID=" + bookID +
                ", title='" + title + '\'' +
                ", author='" + author + '\'' +
                ", genre='" + genre + '\'' +
                ", availabilityStatus=" + availabilityStatus +
                ", qty=" + qty +
                ", admin=" + admin +
                ", transactionList=" + transactionList +
                ", branch=" + branch +
                '}';
    }

    public Book toEntity(){
        Book bookEntity = new Book();
        bookEntity.setBookID(this.bookID);
        bookEntity.setTitle(this.title);
        bookEntity.setAuthor(this.author);
        bookEntity.setGenre(this.genre);
        bookEntity.setAvailabilityStatus(this.availabilityStatus);
        bookEntity.setQty(this.qty);
        bookEntity.setAdmin(this.admin);
        bookEntity.setBranch(this.branch);

        List<Transaction> transactions = new ArrayList<>();
        for (TransactionDto transactionDto : this.transactionList) {
            transactions.add(transactionDto.toEntity());
        }
        bookEntity.setTransactionList(transactions);
        return bookEntity;

    }
}
