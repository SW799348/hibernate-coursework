package lk.ijse.hibernate.coursework.repository.impl;

import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.repository.inter.BookRepository;
import org.hibernate.Session;
import org.hibernate.query.Query;

import java.util.List;

public class BookRepositoryImpl implements BookRepository {

    private Session session;

    private static BookRepositoryImpl bookRepositoryImpl;

    private BookRepositoryImpl() {
    }

    public static BookRepositoryImpl getInstance(){
        return null==bookRepositoryImpl? bookRepositoryImpl=new BookRepositoryImpl() : bookRepositoryImpl;
    }
    @Override
    public void setSession(Session session) {
       this.session=session;
    }
    @Override
    public Long save(Book book) {
        return (Long) session.save(book);
    }

    @Override
    public void update(Book book) {
        session.update(book);
    }

    @Override
    public Book get(Long id) {
        return session.get(Book.class,id);
    }

    @Override
    public void delete(Book book) {
        session.delete(book);
    }



    @Override
    public List<Book> getAllBooks() {
        String sql="SELECT B FROM Book AS B ";
        Query query = session.createQuery(sql);
        List list = query.list();
        session.close();
        return list;
    }
}
