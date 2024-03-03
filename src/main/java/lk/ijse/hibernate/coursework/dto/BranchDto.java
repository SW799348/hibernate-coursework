package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Branch;

import java.io.Serializable;

public class BranchDto implements Serializable {

    private Long branchID;
    private String branchName;
    private String location;

    public BranchDto() {
    }

    public BranchDto(Long branchID, String branchName, String location) {
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

    @Override
    public String toString() {
        return "BranchDto{" +
                "branchID=" + branchID +
                ", branchName='" + branchName + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
    public Branch toEntity(){
        Branch branchDto = new Branch();
        branchDto.setBranchID(this.branchID);
        branchDto.setBranchName(this.branchName);
        branchDto.setLocation(this.location);
        return branchDto;
    }
}
