package com.krealll.day6.model.entity;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BookWarehouse {

    private final static int MAX_CAPACITY=10000;
    private static BookWarehouse instance;
    private List<Book> books;

    private BookWarehouse(){
        books = new ArrayList<>();
    }

    public static BookWarehouse getInstance(){
        if(instance==null){
            instance = new BookWarehouse();
        }
        return instance;
    }

    public List<Book> getBooks(){
        return Collections.unmodifiableList(books);
    }

    public boolean addBook(Book book){
        boolean result = false;
        if(!books.contains(book)||books.size()<MAX_CAPACITY){
            result = books.add(book);
        }
        return result;
    }

    public boolean removeBook(Book book){
        return books.remove(book);
    }
}
