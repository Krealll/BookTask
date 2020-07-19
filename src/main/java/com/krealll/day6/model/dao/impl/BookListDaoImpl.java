package com.krealll.day6.model.dao.impl;

import com.krealll.day6.model.dao.BookListDao;
import com.krealll.day6.model.entity.Book;
import com.krealll.day6.model.entity.BookWarehouse;
import com.krealll.day6.model.exception.DaoException;

import java.lang.reflect.Array;
import java.util.*;

public class BookListDaoImpl implements BookListDao {

    public List<Book> add(Book book) throws DaoException {
        boolean result = BookWarehouse.getInstance().addBook(book);
        if(!result){
            throw new DaoException("Error while adding");
        }
        return BookWarehouse.getInstance().getBooks();
    }

    public List<Book> findAll() {
        List<Book> resultList = BookWarehouse.getInstance().getBooks();
        return resultList;
    }

    public List<Book> findByAuthor(String... author) {
        List<Book> books = BookWarehouse.getInstance().getBooks();
        List<Book> resultList = new ArrayList<>();
        for (Book book:
             books) {
            if(Arrays.equals(book.getAuthor(),author)){
                resultList.add(book);
            }
        }
        return resultList;
    }

    public List<Book> findByNumberOfPages(int numberOfPages) {
        List<Book> books = BookWarehouse.getInstance().getBooks();
        List<Book> resultList = new ArrayList<>();
        for (Book book:
                books) {
            if(book.getNumberOfPages()==numberOfPages){
                resultList.add(book);
            }
        }
        return resultList;
    }

    public List<Book> findByName(String name) {
        List<Book> books = BookWarehouse.getInstance().getBooks();
        List<Book> resultList = new ArrayList<>();
        for (Book book:
                books) {
            if(book.getName().equals(name)){
                resultList.add(book);
            }
        }
        return resultList;    }

    @Override
    public Optional<Book> findById(long id) {
        List<Book> books = BookWarehouse.getInstance().getBooks();
        Optional<Book> result = Optional.empty();
        for (Book book:
                books) {
            if(book.getBookId()==id){
                result = Optional.of(book);
            }
        }
        return result;
    }

    public List<Book> sortByName() {
        List<Book> books = BookWarehouse.getInstance().getBooks();
        List<Book> resultList = new ArrayList<>(books);
        resultList.sort(Comparator.comparing(Book::getName));
        return resultList;
    }

    public List<Book> sortByNumberOfPages() {
        List<Book> books = BookWarehouse.getInstance().getBooks();
        List<Book> resultList = new ArrayList<>(books);
        resultList.sort(Comparator.comparingInt(Book::getNumberOfPages));
        return resultList;
    }

    public List<Book> sortByAuthor() {
        List<Book> books = BookWarehouse.getInstance().getBooks();
        List<Book> resultList = new ArrayList<>(books);
        resultList.sort(Comparator.comparing(Book::getAuthorLine));
        return resultList;
    }

    public List<Book> sortById() {
        List<Book> books = BookWarehouse.getInstance().getBooks();
        List<Book> resultList = new ArrayList<>(books);
        resultList.sort(Comparator.comparingLong(Book::getBookId));
        return resultList;
    }

    public List<Book> remove(Book book) throws DaoException {
        if(!BookWarehouse.getInstance().removeBook(book)){
            throw new DaoException("Error while removing");
        }
        return BookWarehouse.getInstance().getBooks();
    }
}
