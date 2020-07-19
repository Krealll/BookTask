package com.krealll.day6.model.entity;

import com.krealll.day6.util.IdGenerator;

import java.util.Arrays;

public class Book {

    private long bookId;
    private String[] author;
    private String name;
    private int numberOfPages;

    public Book(String[] author, String name, int numberOfPages) {
        this.bookId = IdGenerator.generateId();
        this.author = author;
        this.name = name;
        this.numberOfPages = numberOfPages;
    }

    public Book() {

    }

    public static Builder newBuilder() {
        return new Book().new Builder();
    }

    public long getBookId() {
        return bookId;
    }

    public String getAuthorLine() {
        String delimiter = ", ";
        return String.join(delimiter,author);
    }

    public String[] getAuthor(){
        return author;
    }

    public String getName() {
        return name;
    }

    public int getNumberOfPages() {
        return numberOfPages;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Book book = (Book) o;
        if(bookId!=book.bookId||!name.equals(book.name)||numberOfPages!=book.numberOfPages){
            return false;
        }
        return Arrays.equals(author,book.author);
    }

    @Override
    public int hashCode() {
        int result =(int)(bookId-(bookId>>>32));
        result = 31 * result + numberOfPages;
        result = 31 * result + (name!=null? name.hashCode():0);
        result = 31 * result +Arrays.hashCode(author);
        return result;
    }

    @Override
    public String toString() {
        final StringBuilder result = new StringBuilder("Book{");
        result.append("id:").append(bookId);
        result.append(", authors:").append(Arrays.toString(author));
        result.append(", name:\"").append(name).append('\"');
        result.append(", numberOfPages:").append(numberOfPages);
        result.append('}');
        return result.toString();
    }

    public class Builder{
        private Builder(){
            Book.this.bookId=0;
            Book.this.numberOfPages=0;
            Book.this.name="";
            Book.this.author= new String[0];
        }

        public Builder setId(long id){
            Book.this.bookId=id;
            return this;
        }

        public Builder setName(String name){
            Book.this.name=name;
            return this;
        }

        public Builder setAuthor(String... author){
            Book.this.author = author;
            return this;
        }

        public Builder setNumberOfPages(int numberOfPages){
            Book.this.numberOfPages=numberOfPages;
            return this;
        }

        public Book build(){
            if(Book.this.bookId==0){
                Book.this.bookId=IdGenerator.generateId();
            }
            return Book.this;
        }
    }
}
