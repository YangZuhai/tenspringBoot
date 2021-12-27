package com.hxzyyn.dao;

import com.hxzyyn.entity.Book;

import java.util.List;

public interface BookDao {
    /**
     * 查询全部
     * @return
     */
    List<Book> findAll();


    /**
     * 根据条件查
     * @param book
     * @return
     */
    Book byWhere(Book book);


    /**
     * 添加数据
     */
    void addBook(Book book);

    /**
     * 修改数据
     * @param book
     */
    void updateBook(Book book);

    /**
     * 删除数据
     * @param book
     */
    void deleteBook(int id);
}
