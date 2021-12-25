package com.hxzyyn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzyyn.entity.Book;

import java.util.List;

public interface BookDao extends BaseMapper<Book> {
    /**
     * 查询全部
     * @return
     */
    List<Book> findAll(Book book);

    /**
     * 添加数据
     */
    void addBook(Book book);
}
