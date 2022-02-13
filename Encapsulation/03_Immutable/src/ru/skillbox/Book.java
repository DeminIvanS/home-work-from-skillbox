package ru.skillbox;

import java.io.StringWriter;

public class Book {
    private final String name;
    private final String writer;
    private final int countPages;
    private final int ISBN;

    public Book(String name,String writer,int countPages,int ISBN) {
        this.name = name;
        this.writer = writer;
        this.countPages = countPages;
        this.ISBN = ISBN;
    }

    public String getName() {
        return name;
    }

    public String getWriter() {
        return writer;
    }

    public int getCountPages() {
        return countPages;
    }

    public int getISBN() {
        return ISBN;
    }






}
