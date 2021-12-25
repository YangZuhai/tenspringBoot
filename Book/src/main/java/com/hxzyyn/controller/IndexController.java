//package com.hxzyyn.controller;
//
//
//import com.hxzyyn.entity.User;
//import com.hxzyyn.service.UserService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.web.bind.annotation.*;
//
//import javax.servlet.ServletContext;
//import javax.servlet.http.HttpServletRequest;
//import java.util.HashMap;
//
//@Controller
//@RequestMapping("page")
//public class IndexController {
//
//    @Autowired
//    private UserService userService;
//
//
//    @GetMapping("login")
//    public String login() {
//
//        return "/page/login";
//    }
//
//    @PostMapping(value = "login", produces = "application/json;charset=UTF-8")
//    @ResponseBody
//    public HashMap<String, Object> login(@RequestParam String username, @RequestParam String password, HttpServletRequest request) {
//        HashMap<String, Object> map = new HashMap<String, Object>();
//        ServletContext application=request.getSession().getServletContext();
//        try {
//            User user = new User();
//            user.setName(username);
//            user.setPassword(password);
//            User login = userService.login(user);
//            if (login == null) {
//                map.put("cs", false);
//                map.put("msg", "账号或密码错误");
//                return map;
//            }
//
//            if(login.getUsertype()!=1){
//                map.put("cs",false);
//                map.put("msg","您并非管理员");
//                return map;
//            }
//
//            map.put("cs", true);
//            map.put("msg", "可以登录");
//            application.setAttribute("user",login);
//            return map;
//
//
////                    user.
//
//        } catch (Exception e) {
//            e.printStackTrace();
//        }
//        return null;
//    }
//}
