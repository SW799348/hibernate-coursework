package lk.ijse.hibernate.coursework.entity;

import javax.persistence.*;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "library_branches")

public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchID;

    private String branchName;
    private String location;

    @ManyToOne
    private Admin admin;

    @OneToMany(mappedBy = "branch")
    private List<Book> bookList;

    public Branch() {
    }

    public Branch(Long branchID, String branchName, String location, Admin admin, List<Book> bookList) {
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

    public List<Book> getBookList() {
        return bookList;
    }

    public void setBookList(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public String toString() {
        return "Branch{" +
                "branchID=" + branchID +
                ", branchName='" + branchName + '\'' +
                ", location='" + location + '\'' +
                ", admin=" + admin +
                ", bookList=" + bookList +
                '}';
    }
}
