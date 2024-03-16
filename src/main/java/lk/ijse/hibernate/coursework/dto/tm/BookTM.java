package lk.ijse.hibernate.coursework.dto.tm;


import lk.ijse.hibernate.coursework.dto.AdminDTO;
import lk.ijse.hibernate.coursework.dto.LibraryBranchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data

public class BookTM {

    private Long id;

    private String title;
    private String author;
    private String gener;
    private int qty;
    private AdminDTO admin;
    private LibraryBranchDTO libraryBranch;



}
