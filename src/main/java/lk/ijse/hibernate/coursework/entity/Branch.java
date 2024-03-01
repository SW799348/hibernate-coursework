package lk.ijse.hibernate.coursework.entity;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "library_branches")

public class Branch {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long branchID;

    private String branchName;
    private String location;

    public Branch() {
    }

    public Branch(Long branchID, String branchName, String location) {
        this.branchID = branchID;
        this.branchName = branchName;
        this.location = location;
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
}
