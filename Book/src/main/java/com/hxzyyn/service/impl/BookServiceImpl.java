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
    public List<Book> findAll(Book book) {
        return bookDao.findAll(book);
    }

    @Override
    public void addBook(Book book) {
        bookDao.insert(book);
    }

    @Override
    public Book byWhere(int id) {
        return bookDao.selectById(id);
    }

    @Override
    public void updateBook(Book book) {
        bookDao.updateById(book);
    }

    @Override
    public void delBook(int id) {
        bookDao.deleteById(id);
    }
}
