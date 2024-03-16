package lk.ijse.hibernate.coursework.entity;

import lk.ijse.hibernate.coursework.dto.LibraryBranchDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
@Entity
@Table(name = "libraryBranch")

public class LibraryBranch {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;
    private String location;
    @ManyToOne
    private Admin admin;

    @OneToMany(mappedBy = "libraryBranch")
    private List<Book> books;


    public LibraryBranchDTO toDTO(){
        LibraryBranchDTO libraryBranchDTO = new LibraryBranchDTO();
        libraryBranchDTO.setId(this.id);
        libraryBranchDTO.setName(this.name);
        libraryBranchDTO.setLocation(this.location);
//        if (this.admin!=null) {
//            libraryBranchDTO.setAdmin(this.admin.toDTO());
//        }
//        if (this.books!=null) {
//            List<BookDTO> bookDTOS = new ArrayList<>();
//            for (Book book : books) {
//                bookDTOS.add(book.toDTO());
//            }
//            libraryBranchDTO.setBooks(bookDTOS);
//        }
        return libraryBranchDTO;
    }
}
