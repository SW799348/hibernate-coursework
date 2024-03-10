package lk.ijse.hibernate.coursework.service.impl;


import lk.ijse.hibernate.coursework.dto.BookDto;
import lk.ijse.hibernate.coursework.service.inter.BookService;

import java.util.List;

public class BookServiceImpl implements BookService {

    @Override
    public Long saveBook(BookDto bookDto) {
        return null;
    }

    @Override
    public BookDto getBook(long id) {
        return null;
    }

    @Override
    public boolean updateBook(BookDto bookDto) {
        return false;
    }

    @Override
    public boolean deleteBook(BookDto book) {
        return false;
    }

    @Override
    public List<BookDto> getAllBooks() {
        return null;
    }
}
