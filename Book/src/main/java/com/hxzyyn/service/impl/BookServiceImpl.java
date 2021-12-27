package com.hxzyyn.service.impl;

import com.hxzyyn.dao.BookDao;
import com.hxzyyn.entity.Book;
import com.hxzyyn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class BookServiceImpl implements BookService {

    @Autowired
    private BookDao bookDao;

    @Override
    public List<Book> findAll() {
        return bookDao.findAll();
    }

    @Override
    public Book byWhere(Book book) {
        return bookDao.byWhere(book);
    }

    @Override
    public void addBook(Book book) {
        bookDao.addBook(book);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateBook(book);
    }

    @Override
    public void deleteBook(int id) {
        bookDao.deleteBook(id);
    }


}
