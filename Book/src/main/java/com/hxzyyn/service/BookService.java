package com.hxzyyn.service;

import com.hxzyyn.entity.Book;

import java.util.List;

public interface BookService {
    List<Book> findAll(Book book);

    void addBook(Book book);

    Book byWhere(int id);

    void updateBook(Book book);

    void delBook(int id);
}
