package lk.ijse.hibernate.coursework.service.inter;

import lk.ijse.hibernate.coursework.dto.BookDto;

import java.util.List;

public interface BookService {

    Long saveBook(BookDto bookDto);
    BookDto getBook(Long id);

    boolean updateBook(BookDto bookDto);

    boolean deleteBook(BookDto bookDto);

    List<BookDto> getAllBooks();

}
