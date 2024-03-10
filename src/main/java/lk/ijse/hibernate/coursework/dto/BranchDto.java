package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Admin;
import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.Branch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class BranchDto implements Serializable {

    private Long branchID;
    private String branchName;
    private String location;

    private Admin admin;
    private List<BookDto> bookList;


    public Branch toEntity(){
        Branch branchDto = new Branch();
        branchDto.setBranchID(this.branchID);
        branchDto.setBranchName(this.branchName);
        branchDto.setLocation(this.location);
        branchDto.setAdmin(this.admin);

        List<Book> books=new ArrayList<>();
        for(BookDto bookDto : this.bookList){
            books.add(bookDto.toEntity());
        }
        branchDto.setBookList(books);
        return branchDto;
    }
}
