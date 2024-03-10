package lk.ijse.hibernate.coursework.service.inter;

import lk.ijse.hibernate.coursework.dto.BookDto;
import lk.ijse.hibernate.coursework.dto.UserDto;
import lk.ijse.hibernate.coursework.service.SuperService;

import java.util.List;

public interface BookService  extends SuperService {

    Long saveBook(BookDto bookDto);
    BookDto getBook(long id);
    boolean updateBook(BookDto bookDto);
    boolean deleteBook(BookDto book);
    List<BookDto> getAllBooks();

}
