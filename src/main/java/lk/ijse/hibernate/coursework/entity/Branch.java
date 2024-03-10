package lk.ijse.hibernate.coursework.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import javax.persistence.*;
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


}
