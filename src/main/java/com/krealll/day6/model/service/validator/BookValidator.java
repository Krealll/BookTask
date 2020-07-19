package com.krealll.day6.model.service.validator;

import com.krealll.day6.model.entity.Book;

public class BookValidator {

    private static final int MIN_NUMBER_OF_PAGES = 15;
    private static final int MAX_NUMBER_OF_PAGES = 150_000;
    private static final String INVALID_BOOK_DATA_MESSAGE = "Invalid book data";

    public static String getInvalidBookDataMessage() {
        return INVALID_BOOK_DATA_MESSAGE;
    }

    public static boolean validateBook(Book book){
        return validateAuthor(book.getAuthor())
                &&validateNumberOfPages(book.getNumberOfPages())
                &&validateName(book.getName());
    }

    public static boolean validateNumberOfPages(int numberOfPages){
        boolean result = true;
        if(numberOfPages>MAX_NUMBER_OF_PAGES||numberOfPages<MIN_NUMBER_OF_PAGES){
            result = false;
        }
        return result;
    }

    public static boolean validateName(String name){
        boolean result = true;
        if(name.length()==0){
            result = false;
        }
        return result;
    }

    public static boolean validateAuthor(String[] authors){
        boolean result = true;
        for (String author:
             authors) {
            if(author.length()==0){
                result = false;
                break;
            }
        }
        return result;
    }
}
