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

    private AdminDto adminDto;
    private List<BookDto> bookList;


    public Branch toEntity(){
        Branch branchEntity = new Branch();

        branchEntity.setBranchID(this.branchID);
        branchEntity.setBranchName(this.branchName);
        branchEntity.setLocation(this.location);

        if(adminDto!=null){
            branchEntity.setAdmin(adminDto.toEntity());
        }

        if (bookList!=null){
            List<Book> books=new ArrayList<>();
            for(BookDto bookDto : this.bookList){
                books.add(bookDto.toEntity());
            }
            branchEntity.setBookList(books);
        }


        return branchEntity;
    }
}
