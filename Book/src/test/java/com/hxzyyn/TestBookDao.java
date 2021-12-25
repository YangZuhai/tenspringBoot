package com.hxzyyn;

import com.hxzyyn.dao.BookDao;
import com.hxzyyn.entity.Book;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class TestBookDao extends TestMain {

    @Autowired
    private BookDao bookDao;

    @Test
    public void testAddBook() {

        try {
            Book book = new Book();
            book.setName("张三讲法");
            book.setAuthor("张三");
            book.setPublish("不详");
            book.setPublicshdate(new Date());
            book.setPage(900);
            book.setPrice(500);
            System.out.println(bookDao.insert(book));
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testFindAll() {
        try {
            Book book1 = new Book();
//            book1.setId(1);
            bookDao.findAll(book1).forEach(book -> System.out.println(book));
//        bookDao.selectList(null).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
