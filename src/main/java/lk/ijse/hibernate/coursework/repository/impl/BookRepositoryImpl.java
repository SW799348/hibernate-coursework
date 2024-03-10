package lk.ijse.hibernate.coursework.repository.impl;

import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.repository.inter.BookRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.ArrayList;
import java.util.List;

public class BookRepositoryImpl implements BookRepository {


    @Override
    public Long save(Book object) {
        return null;
    }

    @Override
    public void update(Book object) {

    }

    @Override
    public Book get(Long aLong) {
        return null;
    }

    @Override
    public void delete(Book object) {

    }

    @Override
    public ArrayList<Book> getAll() {
        return null;
    }

    @Override
    public void setSession(Session session) {

    }
}
