package com.hxzyyn.controller;

import com.hxzyyn.entity.Account;
import com.hxzyyn.service.AccountService;
import javafx.application.Application;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.util.HashMap;

/**
 * @author lulei
 * @date 2021年12月15日 11:17:39
 */

@Controller
@RequestMapping("account")
public class AccountController {

    @Autowired
    private AccountService acountService;

    @PostMapping(value = "login",produces = "application/json;charset=UTF-8")
    @ResponseBody
    public HashMap<String, Object> login(@RequestBody Account accountOne, HttpServletRequest request) {
        System.out.println("拿到了" + accountOne.getCardno());
        Account accountTwo =acountService.login(accountOne.getCardno());
        HashMap<String, Object> map = new HashMap<String, Object>(16);

        ServletContext application = request.getSession().getServletContext();

        if (accountTwo == null) {
            map.put("success", false);
            map.put("msg","登录失败,你输入的卡号不存在");
            return map;
        }
//        密码不正确
        if(!accountTwo.getPassword().equals(accountOne.getPassword())){
            map.put("success",false);
            map.put("msg","登录失败!密码错误");
            return map;
        }
//        账户已冻结
        if(accountTwo.getStatus()==0){
            map.put("success",false);
            map.put("msg","登录失败,账户已冻结");
            return map;
        }
//         登录成功\
        map.put("success",true);
        map.put("msg","欢迎"+accountOne.getCardno()+"卡号用户");
        application.setAttribute("account",accountTwo);
        return map;
    }
}
