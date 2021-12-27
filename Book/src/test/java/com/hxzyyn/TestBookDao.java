package com.hxzyyn;

import com.hxzyyn.dao.BookDao;
import com.hxzyyn.entity.Book;
import org.junit.jupiter.api.RepeatedTest;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.Date;

public class TestBookDao extends TestMain {

    @Autowired
    private BookDao bookDao;

//    @Test
//    public void testAddBook() {
//
//        try {
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//    }

    @Test
    public void testFindAll() {
        try {
            Book book1 = new Book();
    //            book1.setId(1);
    //            book1.setName("新华字典22");
//            book1.setPublish("中央出版社");
//            book1.setId(1);
            bookDao.findAll().forEach(book -> System.out.println(book));
//        bookDao.selectList(null).forEach(System.out::println);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
    @Test
    public void testUpdateBook(){
        try{
            Book book = new Book();
            book.setId(1);
            book.setName("新华字典22");
            bookDao.updateBook(book);
            testFindAll();
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    @Test
    public void testAddBook(){
        try{
            Book book = new Book();
            book.setName("张三讲法4");
            book.setAuthor("张三");
            book.setPublish("不详");
            book.setPublicshdate(new Date());
            book.setPage(500);
            book.setPrice(500.5);
            book.setContent(".....");
            bookDao.addBook(book);
            testFindAll();
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
