package com.krealll.day6.model.service.parser;

import com.krealll.day6.model.entity.Book;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Optional;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class CustomParser {

    private final static String NAME_REG_EX = "^[A-Za-z0-9\\s\\-_,;:()]+$";
    private final static String LAST_NAME_REG_EX = "^[A-Z][a-z0-9]*$";
    private final static String AUTHORS_FIRST_AND_MIDDLE_NAME_REG_EX = "^( [A-Z]\\.([A-Z]\\.)?)?$";
    private final static String AUTHOR_REG_EX = "^("+LAST_NAME_REG_EX+AUTHORS_FIRST_AND_MIDDLE_NAME_REG_EX+" )+$";
    private final static String PARAM_SPLIT_PATTERN = "; ";
    private final static String AUTHORS_SPLIT_PATTERN = ", ";

    public static String getAuthorsSplitPattern() {
        return AUTHORS_SPLIT_PATTERN;
    }

    public Optional<Book> parseBook(String paramString){
        Optional<Book> result;
        Book tempBook;
        Optional<Integer> number;
        ArrayList<String> paramArray = new ArrayList<>();
        Collections.addAll(paramArray,paramString.split(PARAM_SPLIT_PATTERN));
        number = parseNumberOfPages(paramArray.get(2));
        Optional<String> name = parseName(paramArray.get(0));
        Optional<String[]> authors = parseAuthor(paramArray.get(1));
        if(!name.isPresent()||!authors.isPresent()||authors.get().length==0||!number.isPresent()){
            result = Optional.empty();
        } else {
            tempBook = Book.newBuilder()
                    .setName(name.get())
                    .setAuthor(authors.get())
                    .setNumberOfPages(number.get())
                    .build();
            result = Optional.of(tempBook);
        }
        return result;
    }

    public Optional<Integer> parseNumberOfPages(String number){
        Optional<Integer> resultNumber;
        try{
            resultNumber = Optional.of(Integer.parseInt(number));
        } catch (NumberFormatException e){
            resultNumber = Optional.empty();
        }
        return resultNumber;
    }

    public Optional<String> parseName(String name){
        Optional<String> resultNum =Optional.empty();
        Pattern pattern = Pattern.compile(NAME_REG_EX);
        Matcher matcher = pattern.matcher(name);
        if(matcher.matches()){
            resultNum = Optional.of(name);
        }
        return resultNum;
    }

    public Optional<String[]> parseAuthor(String authors){
        Matcher matcher;
        ArrayList<String> authorArray = new ArrayList<>();
        Collections.addAll(authorArray,authors.split(AUTHORS_SPLIT_PATTERN));
        String[] tempString = new String[authorArray.size()];
        authorArray.toArray(tempString);    /////?????
        Optional<String[]> arrayResult = Optional.of(tempString);
        Pattern pattern = Pattern.compile(AUTHOR_REG_EX);
        for (String author:
             authorArray) {
            matcher = pattern.matcher(author);
            if(!matcher.matches()){
                arrayResult =  Optional.empty();
                break;
            }
        }
        return arrayResult;
    }

    public Optional<Long> parseId(String id){
        Optional<Long> resultId;
        try{
            resultId = Optional.of(Long.parseLong(id));
        } catch (NumberFormatException e){
            resultId = Optional.empty();
        }
        return resultId;
    }
}
