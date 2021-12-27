package com.hxzyyn.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hxzyyn.dao.RecordDao;
import com.hxzyyn.entity.Account;
import com.hxzyyn.entity.Record;
import com.hxzyyn.service.AccountService;
import com.hxzyyn.service.RecordService;
import com.hxzyyn.utils.PageTwo;
import com.hxzyyn.utils.PageUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;

/**
 * @author lulei
 * @date 2021年12月15日 17:35:30
 */

@Controller
@RequestMapping("home")
public class HomeController {

    @Autowired
    private AccountService accountService;

    @Autowired
    private RecordService recordService;

    @Autowired
    private PageTwo pageTwo;

    @Autowired
    private PageUtils pageUtils;

    @Autowired
    private RecordDao recordDao;

    @GetMapping("index")
    public String index(HttpServletRequest request, String flag) {
        ServletContext application = request.getSession().getServletContext();
        Account account = (Account) application.getAttribute("account");
        System.out.println("拿到了" + account.toString());

        String url = request.getContextPath();
        request.setAttribute("URL", url);

        if ("balance".equals(flag)) {
            request.setAttribute("url", url + "/home/balance");
            return "/home";
        }


        if ("transfer".equals(flag)) {
            request.setAttribute("url", url + "/home/transfer");
            return "/home";
        }

        if ("transferTwo".equals(flag)) {
            request.setAttribute("url", url + "/home/transferTwo");
            return "/home";
        }

        if ("record".equals(flag)) {
            request.setAttribute("url", url + "/home/recordTwo?currentSize=&dateOne=&dateTwo=");
            return "/home";
        }

        if ("password".equals(flag)) {
            request.setAttribute("url", url + "/home/password");
            return "/home";
        }


        if (flag == null || "".equals(flag)) {
            request.setAttribute("url", url + "/home/welcome");
            return "/home";
        }

        return null;
    }

    @GetMapping("write")
    public String write( HttpServletRequest request) {
        ServletContext application = request.getSession().getServletContext();
        if (application.getAttribute("account") != null) {
            application.removeAttribute("account");
        }
        return "forward:/home/index";
    }


    @GetMapping("welcome")
    public String welcome() {

        return "/welcome";
    }

    @GetMapping("balance")
    public String balance(HttpServletRequest request, Model model) {
        ServletContext application = request.getSession().getServletContext();
        Account account = (Account) application.getAttribute("account");
        double money = accountService.getAccountByCode(account.getCardno());
        model.addAttribute("money", money);
        return "/balance";
    }

    @GetMapping("transfer")
    public String transfer() {

        return "/transfer";
    }

    @GetMapping("transferTwo")
    public String transferTwo(Model model) {
        model.addAttribute("pandin", "1");
        return "/transfer";
    }

    @PostMapping(value = "transfer", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public HashMap<String, Object> transfer(@RequestBody Account account, HttpServletRequest request) {
        try {
            System.out.println("-------------------开始运行--------------------");
            long timeOne = System.currentTimeMillis();
            System.out.println("拿到的卡号为:" + account.getCardno());
            HashMap<String, Object> map = new HashMap<>(16);

            double money = account.getBalance();

//         当前账户
            ServletContext application = request.getSession().getServletContext();
            Account accountApplication = (Account) application.getAttribute("account");
            Account thisAccount = accountService.login(accountApplication.getCardno());
//            目标账户
//            double moneys = Double.parseDouble(money);
            Account tragetAccount = accountService.login(account.getCardno());
//            账号不存在
            if (tragetAccount == null) {
                map.put("success", false);
                map.put("msg", "目标账户不存在");
                return map;
            }
            if (tragetAccount.getStatus() == 0) {
                map.put("success", false);
                map.put("msg", "目标账户已冻结");
                return map;
            }
            if (thisAccount.getBalance() < money) {
                map.put("success", false);
                map.put("msg", "转出余额不足");
                return map;
            }
//            当前账户减
            accountService.update(money, thisAccount.getCardno(), "sub");
            System.out.println("当前信息修改成功");
//            目标账户加
            accountService.update(money, tragetAccount.getCardno(), "add");
            System.out.println("对方信息修改成功");
//            当前卡号记录
            System.out.println("当前修改后的卡号余额:" + thisAccount.getBalance());
            System.out.println("当前修改后的卡号余额-:" + (thisAccount.getBalance() - money));
            Record thisRecord = new Record(0, thisAccount.getCardno(), new Date(), money, 0, (thisAccount.getBalance() - money), "消费", null);
            recordService.addRecordData(thisRecord);
            System.out.println("当前卡号记录成功");
//            目标卡号记录
            System.out.println("目标修改后的卡号余额:" + tragetAccount.getBalance());
            System.out.println("目标修改后的卡号余额+:" + (tragetAccount.getBalance() + money));
            Record trageRecord = new Record(0, tragetAccount.getCardno(), new Date(), 0, money, (tragetAccount.getBalance() + money), "收入", null);
            recordService.addRecordData(trageRecord);
            System.out.println("目标卡号记录成功");
            map.put("success", true);
            map.put("msg", "转账成功");
            long timeTwo = System.currentTimeMillis();
            System.out.println("运行结束\n运行时间:" + (timeTwo - timeOne) + "s");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }


    @RequestMapping("recordTwo")
    public String success(@RequestParam String dateOne, @RequestParam String dateTwo, @RequestParam String currentSize, Model model, HttpServletRequest request) throws ParseException {
        HttpSession session = request.getSession();
        System.out.println(session.getAttribute("dateOne"));
        System.out.println(session.getAttribute("dateTwo"));
        //        pageTwo.setStartList(null);
        int currentSizeTwo = 0;
//        每页展示条数
        pageTwo.setPageSize(5);

        if (currentSize == null || "".equals(currentSize)) {
            currentSizeTwo = 1;
        } else {
            currentSizeTwo = Integer.parseInt(currentSize);
        }
        Date dateOne1 = null;
        Date dateTwo1 = null;

//        Fri Dec 17 15:00:00 CST 2021

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd'T'HH:mm");
        if (dateOne == null || "".equals(dateOne)) {
            if (session.getAttribute("dateOne") != null) {
                dateOne1 = (Date) session.getAttribute("dateOne");
            }
        }
        if (dateOne != null && !"".equals(dateOne)) {
            dateOne1 = (Date) format.parse(dateOne);
        }

        if (dateTwo == null || "".equals(dateTwo)) {
            if (session.getAttribute("dateTwo") != null) {
                dateTwo1 = (Date) session.getAttribute("dateTwo");
            }
        } else if (dateTwo != null && !"".equals(dateTwo)) {
            dateTwo1 = format.parse(dateTwo);
        }

        session.setAttribute("dateOne", dateOne1);
        session.setAttribute("dateTwo", dateTwo1);

//        拿到当前页
        pageTwo.setCurrPageNo(currentSizeTwo);
//        拿到plus条件对象
        QueryWrapper<Record> wrapper = null;
        if (dateOne1 != null && dateTwo1 != null) {
            wrapper = new QueryWrapper<Record>();
            wrapper.between("transactionDate", dateOne1, dateTwo1);
//            wrapper.orderBy();
        }

        IPage<Record> recordIPage = pageUtils.page(recordDao, pageTwo, wrapper);
//        获取页码集合
        pageTwo.setStartList(new ArrayList<Integer>());
        pageTwo.setAllPageStart(pageTwo.getCurrPageNo(), pageTwo.getPageAll());
        System.out.println(pageTwo.getStartList());

        model.addAttribute("recordList", recordIPage.getRecords());
        model.addAttribute("currentSize", currentSizeTwo);

        model.addAttribute("startList", pageTwo.getStartList());

        model.addAttribute("page", pageTwo);
        return "/record";

    }

    @GetMapping("password")
    public String updatePassword() {

        return "/password";
    }


    @PostMapping(value = "password", produces = "application/json;charset=UTF-8")
    @ResponseBody
    public HashMap<String, Object> updatePassword(@RequestParam("pwd") String pwd, @RequestParam("newPwdOne") String newPwdOne, @RequestParam("newPwdTwo") String newPwdTwo, HttpServletRequest request) {
        try {
            HashMap<String, Object> map = new HashMap<>(16);
            ServletContext application = request.getSession().getServletContext();
            Account thisAccount = (Account) application.getAttribute("account");
            if (!pwd.equals(thisAccount.getPassword())) {
                map.put("cs", false);
                map.put("msg", "旧密码输入错误!");
                return map;
            }
            Account newAccount = new Account(thisAccount.getCardno(), newPwdOne, 0, 0);
            accountService.updatePwd(newAccount);
            map.put("cs", true);
            map.put("msg", "修改密码成功!");
            return map;

        } catch (Exception e) {
            e.printStackTrace();
        }

        return null;
    }

    @GetMapping("ok")
    public String ok() {
        return "/ok";
    }


}
