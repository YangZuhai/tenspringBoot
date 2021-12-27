package com.hxzyyn.controller;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.hxzyyn.entity.Book;
import com.hxzyyn.service.BookService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpSession;
import java.util.List;

@Controller
public class HomeController {
    @Autowired
    private BookService bookService;


    @RequestMapping("findAll")
    public String findAll(@RequestParam String currentSize, @RequestParam String pageSize, Model model, HttpSession session) {
        try {
            int currentPageNo = 0;
            int pageSizeOne = 0;
            if (currentSize == null || "".equals(currentSize)) {
                currentPageNo = 1;
            } else {
                currentPageNo = Integer.parseInt(currentSize);
            }

            if (pageSize == null || "".equals(pageSize)) {
                if (session.getAttribute("pageSize") != null) {
                    pageSizeOne = (int) session.getAttribute("pageSize");

                }else{
                    pageSizeOne = 2;
                }

            } else{
                pageSizeOne = Integer.parseInt(pageSize);
            }
            session.setAttribute("pageSize", pageSizeOne);
            PageHelper.startPage(currentPageNo, pageSizeOne);
            List<Book> list = bookService.findAll();
            PageInfo pageInfo = new PageInfo(list, 3);
            model.addAttribute("pageInfo", pageInfo);
            model.addAttribute("books", list);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/page/home";
    }

    @GetMapping("addBook")
    public String addBook() {

        return "/page/addBook";
    }

    @PostMapping("addBooks")
    public String addBook(Book book) {
        try {
            System.out.println(book);
            bookService.addBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/findAll?currentSize=&pageSize=";
    }

    @GetMapping("updateBook")
    public String updateBook(String id, Model model) {
        try {
            Book book1 = new Book();
            book1.setId(Integer.parseInt(id));
            Book book = bookService.byWhere(book1);
            model.addAttribute("book", book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "/page/updateBook";
    }

    @PostMapping("updateBook")
    public String updateBook(Book book) {
        try {
//            Book book1 = bookService.byWhere(book.getId());
            bookService.updateBook(book);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/findAll?currentSize=&pageSize=";
    }

    @GetMapping("delBook")
    public String delBook(String id) {
        try {
            bookService.deleteBook(Integer.parseInt(id));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "forward:/findAll?currentSize=&pageSize=";
    }


}
