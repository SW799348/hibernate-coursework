package lk.ijse.hibernate.coursework.service.impl;


import lk.ijse.hibernate.coursework.dto.BookDTO;
import lk.ijse.hibernate.coursework.entity.Book;
import lk.ijse.hibernate.coursework.repository.impl.BookRepositoryImpl;
import lk.ijse.hibernate.coursework.repository.inter.BookRepository;
import lk.ijse.hibernate.coursework.service.inter.BookService;
import lk.ijse.hibernate.coursework.util.SessionFactoryConfig;
import org.hibernate.Session;
import org.hibernate.Transaction;

import java.util.ArrayList;
import java.util.List;

public class BookServiceImpl implements BookService {

    private Session session;
    private static BookService bookService;
    private final BookRepository bookRepository;

    private BookServiceImpl(){
        bookRepository=BookRepositoryImpl.getInstance();
    }
    public static BookService getInstance(){
        return (null==bookService)
                ?bookService=new BookServiceImpl()
                :bookService;
    }
    @Override
    public Long saveBook(BookDTO bookDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            bookRepository.setSession(session);
            Long id = bookRepository.save(bookDTO.toEntity());
            transaction.commit();
            session.close();
            return id;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return -1L;
        }
    }

    @Override
    public BookDTO getBook(long id) {
        try {
            session = SessionFactoryConfig.getInstance()
                    .getSession();
            bookRepository.setSession(session);
            Book book = bookRepository.get(id);
            session.close();
            return book.toDTO();
        } catch (Exception ex) {
            ex.printStackTrace();
            throw ex;
        }
    }

    @Override
    public boolean updateBook(BookDTO bookDTO) {
        session = SessionFactoryConfig.getInstance().getSession();
        Transaction transaction = session.beginTransaction();
        try {
            bookRepository.setSession(session);
            bookRepository.update(bookDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            session.close();
            ex.printStackTrace();
            return false;
        }
    }

    @Override
    public boolean deleteBook(BookDTO bookDTO) {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        Transaction transaction = session.beginTransaction();
        try {
            bookRepository.setSession(session);
            bookRepository.delete(bookDTO.toEntity());
            transaction.commit();
            session.close();
            return true;
        } catch (Exception ex) {
            transaction.rollback();
            ex.printStackTrace();
            session.close();
            return false;
        }
    }

    @Override
    public List<BookDTO> getAllBooks() {
        session = SessionFactoryConfig.getInstance()
                .getSession();
        bookRepository.setSession(session);
        List<Book> allBooks= bookRepository.getAll();
        List<BookDTO> bookDTOList = new ArrayList<>();
        for (Book book : allBooks) {
            bookDTOList.add(book.toDTO());
        }
        return bookDTOList;
    }
}
