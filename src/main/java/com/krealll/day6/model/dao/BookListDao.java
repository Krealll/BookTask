package com.krealll.day6.model.dao;

import com.krealll.day6.model.entity.Book;
import com.krealll.day6.model.exception.DaoException;

import java.util.List;
import java.util.Optional;

public interface BookListDao {

    List<Book> add(Book book) throws DaoException;

    List<Book> findAll();

    List<Book> findByAuthor(String... author);

    List<Book> findByNumberOfPages(int numberOfPages);

    List<Book> findByName(String name);

    Optional<Book> findById(long id);

    List<Book> sortByName();

    List<Book> sortByNumberOfPages();

    List<Book> sortByAuthor();

    List<Book> sortById();

    List<Book> remove(Book book) throws DaoException;
    // so on
}
