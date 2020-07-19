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

    public List<Book> addBook(String book) throws  ServiceException {
        List<Book> resultList;
        try{
        CustomParser customParser = new CustomParser();
        Optional<Book> bookOptional = customParser.parseBook(book);
        if(!bookOptional.isPresent()){
            throw new ServiceException(CustomParser.getParseErrorMessage());
        }
        Book tempBook = bookOptional.get();
        if(!BookValidator.validateBook(tempBook)){
            throw new ServiceException(BookValidator.getInvalidBookDataMessage());
        }
        BookListDao bookListDao = new BookListDaoImpl();
        resultList = bookListDao.add(tempBook);
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
        CustomParser customParser = new CustomParser();
        Optional<String[]> authorOptional = customParser.parseAuthor(author);
        if(!authorOptional.isPresent()){
            throw new ServiceException(CustomParser.getParseErrorMessage());
        }
        String[] authorsStrArray = authorOptional.get();
        if(!BookValidator.validateAuthor(authorsStrArray)){
            throw new ServiceException(BookValidator.getInvalidBookDataMessage());
        }
        BookListDao bookListDao = new BookListDaoImpl();
        resultList = bookListDao.findByAuthor(authorsStrArray);
        return resultList;
    }

    public List<Book> findByNumberOfPages(String numberOfPages) throws ServiceException {
        List<Book> resultList;
        CustomParser customParser = new CustomParser();
        Optional<Integer> numberOptional = customParser.parseNumberOfPages(numberOfPages);
        if(!numberOptional.isPresent()){
            throw new ServiceException(CustomParser.getParseErrorMessage());
        }
        int resultNumber = numberOptional.get();
        if(!BookValidator.validateNumberOfPages(resultNumber)){
            throw new ServiceException(BookValidator.getInvalidBookDataMessage());
        }
        BookListDao bookListDao = new BookListDaoImpl();
        resultList = bookListDao.findByNumberOfPages(resultNumber);
        return resultList;
    }

    public List<Book> findByName(String name) throws ServiceException {
        List<Book> resultList;
        CustomParser customParser = new CustomParser();
        Optional<String> nameOptional = customParser.parseName(name);
        if(!nameOptional.isPresent()){
            throw new ServiceException(CustomParser.getParseErrorMessage());
        }
        String resultName = nameOptional.get();
        if(!BookValidator.validateName(resultName)){
            throw new ServiceException(BookValidator.getInvalidBookDataMessage());
        }
        BookListDao bookListDao = new BookListDaoImpl();
        resultList = bookListDao.findByName(resultName);
        return resultList;
    }

    public Optional<Book> findById(String id) throws ServiceException {
        Optional<Book> result;
        CustomParser customParser = new CustomParser();
        Optional<Long> idOptional = customParser.parseId(id);
        if(!idOptional.isPresent()){
            throw new ServiceException(CustomParser.getParseErrorMessage());
        }
        long resultId = idOptional.get();
        BookListDao bookListDao = new BookListDaoImpl();
        result = bookListDao.findById(resultId);
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

    public List<Book> remove(String book) throws ServiceException {
        BookListDao bookListDao = new BookListDaoImpl();
        List<Book> bookList;
        CustomParser customParser = new CustomParser();
        Optional<Book> bookOptional = customParser.parseBook(book);
        if(!bookOptional.isPresent()){
            throw new ServiceException(CustomParser.getParseErrorMessage());
        }
        Book resultBook = bookOptional.get();
        if(!BookValidator.validateBook(resultBook)){
            throw new ServiceException(BookValidator.getInvalidBookDataMessage());
        }
        try {
            bookList = bookListDao.remove(resultBook);
        } catch (DaoException e) {
            throw new ServiceException("Error while removing book");
        }
        return bookList;
    }
}
