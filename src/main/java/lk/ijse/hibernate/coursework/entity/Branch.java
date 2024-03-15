package lk.ijse.hibernate.coursework.entity;

import lk.ijse.hibernate.coursework.dto.BookDto;
import lk.ijse.hibernate.coursework.dto.BranchDto;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

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


    public BranchDto toDto(){
        BranchDto branchDto = new BranchDto();
        branchDto.setBranchID(this.branchID);
        branchDto.setBranchName(this.branchName);
        branchDto.setLocation(this.location);
//        branchDto.setAdmin(this.admin);

//        List<BookDto> bookDtoList=new ArrayList<>();
//        for (Book book : this.bookList){
//            bookDtoList.add(book.toDto());
//        }
//        branchDto.setBookList(bookDtoList);

        return branchDto;
    }
}
