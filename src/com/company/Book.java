package com.company;

public class Book {
    private String name;
    private String author;
    private long ISBN;

    public Book(String name, String author, long ISBN) {
        this.name = name;
        this.author = author;
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAuthor() {
        return author;
    }

    public void setAuthor(String author) {
        this.author = author;
    }

    public long getISBN() {
        return ISBN;
    }

    public void setISBN(long ISBN) {
        this.ISBN = ISBN;
    }


}
