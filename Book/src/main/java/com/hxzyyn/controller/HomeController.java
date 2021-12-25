//package com.hxzyyn.controller;
//
//import com.hxzyyn.entity.Book;
//import com.hxzyyn.service.BookService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//
//@Controller
//public class HomeController {
//    @Autowired
//    private BookService bookService;
//
//
//    @RequestMapping("findAll")
//    public String findAll(Model model) {
//        model.addAttribute("books",bookService.findAll(null));
//        return "/page/home";
//    }
//
//    @GetMapping("addBook")
//    public String addBook(){
//
//        return "/page/addBook";
//    }
//
//    @PostMapping("addBooks")
//    public String addBook(Book book){
//        try{
//            System.out.println(book);
//            bookService.addBook(book);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return "forward:/findAll";
//    }
//
//    @GetMapping("updateBook")
//    public String updateBook(String id,Model model){
//        try{
//            Book book = bookService.byWhere(Integer.parseInt(id));
//            model.addAttribute("book",book);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return "/page/updateBook";
//    }
//
//    @PostMapping("updateBook")
//    public String updateBook(Book book){
//        try{
////            Book book1 = bookService.byWhere(book.getId());
//           bookService.updateBook(book);
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return "forward:/findAll";
//    }
//
//    @GetMapping("delBook")
//    public String delBook(String id){
//        try{
//            bookService.delBook(Integer.parseInt(id));
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return "forward:/findAll";
//    }
//
//
//}
