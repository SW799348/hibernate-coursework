package lk.ijse.hibernate.coursework.service.inter;

import lk.ijse.hibernate.coursework.dto.BookDTO;
import lk.ijse.hibernate.coursework.service.SuperService;

import java.util.List;

public interface BookService  extends SuperService {

    Long saveBook(BookDTO bookDTO);

    BookDTO getBook(long id);

    boolean updateBook(BookDTO bookDTO);

    boolean deleteBook(BookDTO bookDTO);

    List<BookDTO> getAllBooks();

}
