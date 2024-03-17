package lk.ijse.hibernate.coursework.dto;

import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.entity.LibraryBranch;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.ManyToOne;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class LibraryBranchDTO implements Serializable {

    private Long id;

    private String name;
    private String location;

    @ManyToOne
    private AdminDTO admin;

    private List<BookDTO> books;




    public LibraryBranch toEntity() {
        LibraryBranch libraryBranch = new LibraryBranch();
        libraryBranch.setId(this.id);
        libraryBranch.setName(this.name);
        libraryBranch.setLocation(this.location);
        if (this.admin!=null) {
            libraryBranch.setAdmin(this.admin.toEntity());
        }
        if (this.books!=null) {
            List<Book> bookList = new ArrayList<>();
            for (BookDTO bookDto : this.books) {
                bookList.add(bookDto.toEntity());
            }
            libraryBranch.setBooks(bookList);
        }
        return libraryBranch;
    }

}
