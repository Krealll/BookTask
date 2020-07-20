package com.krealll.day6.model.service;

import com.krealll.day6.model.dao.BookListDao;
import com.krealll.day6.model.dao.impl.BookListDaoImpl;
import com.krealll.day6.model.entity.Book;
import com.krealll.day6.model.exception.DaoException;
import com.krealll.day6.model.exception.ServiceException;
import com.krealll.day6.model.service.parser.CustomParser;
import com.krealll.day6.model.service.validator.BookValidator;

import java.util.List;
import java.util.Optional;

public class BookService {

    public List<Book> addBook(Book book) throws  ServiceException {
        List<Book> resultList;
        try{
            if(!BookValidator.validateBook(book)){
                throw new ServiceException(BookValidator.getInvalidBookDataMessage());
            }
            BookListDao bookListDao = new BookListDaoImpl();
            resultList = bookListDao.add(book);
        } catch (DaoException e){
            throw new ServiceException("Error while adding book",e);
        }
        return resultList;
    }

    public List<Book> findAllBooks() {
        BookListDao bookListDao = new BookListDaoImpl();
        return bookListDao.findAll();
    }

    public List<Book> findByAuthor(String author) throws ServiceException {
        List<Book> resultList;
        String[] authorsStrArray = author.split(CustomParser.getAuthorsSplitPattern());
        if(!BookValidator.validateAuthor(authorsStrArray)){
            throw new ServiceException(BookValidator.getInvalidBookDataMessage());
        }
        BookListDao bookListDao = new BookListDaoImpl();
        resultList = bookListDao.findByAuthor(authorsStrArray);
        return resultList;
    }

    public List<Book> findByNumberOfPages(int numberOfPages) throws ServiceException {
        List<Book> resultList;
        if(!BookValidator.validateNumberOfPages(numberOfPages)){
            throw new ServiceException(BookValidator.getInvalidBookDataMessage());
        }
        BookListDao bookListDao = new BookListDaoImpl();
        resultList = bookListDao.findByNumberOfPages(numberOfPages);
        return resultList;
    }

    public List<Book> findByName(String name) throws ServiceException {
        List<Book> resultList;
        if(!BookValidator.validateName(name)){
            throw new ServiceException(BookValidator.getInvalidBookDataMessage());
        }
        BookListDao bookListDao = new BookListDaoImpl();
        resultList = bookListDao.findByName(name);
        return resultList;
    }

    public Optional<Book> findById(long id)  {
        Optional<Book> result;
        BookListDao bookListDao = new BookListDaoImpl();
        result = bookListDao.findById(id);
        return result;
    }

    public List<Book> sortByName() {
        BookListDao bookListDao = new BookListDaoImpl();
        List<Book> sortedBookList  = bookListDao.sortByName();
        return sortedBookList;
    }

    public List<Book> sortByNumberOfPages() {
        BookListDao bookListDao = new BookListDaoImpl();
        List<Book> sortedBookList  = bookListDao.sortByNumberOfPages();
        return sortedBookList;    }

    public List<Book> sortByAuthor() {
        BookListDao bookListDao = new BookListDaoImpl();
        List<Book> sortedBookList  = bookListDao.sortByAuthor();
        return sortedBookList;    }

    public List<Book> sortById() {
        BookListDao bookListDao = new BookListDaoImpl();
        List<Book> sortedBookList  = bookListDao.sortById();
        return sortedBookList;    }

    public List<Book> remove(Book book) throws ServiceException {
        BookListDao bookListDao = new BookListDaoImpl();
        List<Book> bookList;
        if(!BookValidator.validateBook(book)){
            throw new ServiceException(BookValidator.getInvalidBookDataMessage());
        }
        try {
            bookList = bookListDao.remove(book);
        } catch (DaoException e) {
            throw new ServiceException("Error while removing book");
        }
        return bookList;
    }
}
