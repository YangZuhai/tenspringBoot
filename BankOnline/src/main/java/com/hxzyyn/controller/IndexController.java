package com.hxzyyn.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @author lulei
 * @date 2021年12月15日 10:40:25
 */

@Controller
public class IndexController {

    @RequestMapping("login")
    public String login() {

        return "/login";
    }

}
