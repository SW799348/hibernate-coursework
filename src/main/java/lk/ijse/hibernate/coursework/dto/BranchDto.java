package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.Branch;

import java.io.Serializable;
import java.util.List;

public class BranchDto implements Serializable {

    private Long branchID;
    private String branchName;
    private String location;

    private Admin admin;
    private List<BookDto> bookList;

    public BranchDto(Long branchID, String branchName, String location, Admin admin, List<BookDto> bookList) {
        this.branchID = branchID;
        this.branchName = branchName;
        this.location = location;
        this.admin = admin;
        this.bookList = bookList;
    }

    public Long getBranchID() {
        return branchID;
    }

    public void setBranchID(Long branchID) {
        this.branchID = branchID;
    }

    public String getBranchName() {
        return branchName;
    }

    public void setBranchName(String branchName) {
        this.branchName = branchName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public Admin getAdmin() {
        return admin;
    }

    public void setAdmin(Admin admin) {
        this.admin = admin;
    }

    public List<BookDto> getBookList() {
        return bookList;
    }

    public void setBookList(List<BookDto> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "BranchDto{" +
                "branchID=" + branchID +
                ", branchName='" + branchName + '\'' +
                ", location='" + location + '\'' +
                ", admin=" + admin +
                ", bookList=" + bookList +
                '}';
    }
}
