package com.hxzyyn;


import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxzyyn.dao.AccountDao;
import com.hxzyyn.entity.Account;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

/**
 * @author lulei
 * @date 2021年12月15日 11:08:32
 */

@SpringBootTest
public class TestAccountDao {

    @Autowired
    private AccountDao acountDao;

    @Test
    public void testLogin() {
//        System.out.println(acountDao.login(6217003860019691452L));
      /*  QueryWrapper<Account> wrapper = new QueryWrapper<>();
        wrapper.eq("cardno", 6217003860019691452L);
        System.out.println(acountDao.selectList(wrapper));*/

        try {
            System.out.println(acountDao.login(6217003860019691452L).toString());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testAllByDouble() {
        double i = acountDao.getAccountByCode(6217003860019691452L);
        System.out.println(i);
    }


    @Test
    public void testTransfer() {
        try {
            QueryWrapper<Account> accountQueryWrapper = new QueryWrapper<>();
            accountQueryWrapper.eq("cardno", "6217003860017895213");
//            List<Account> accountOne =  acountDao.selectList(accountQueryWrapper);
//            accountOne.forEach(System.out::println);*/
            String account = "6217003860017895213";
            Account accountOne = acountDao.selectById(account);
//            System.out.println(accountOne.toString());
            System.out.println(accountOne.getBalance());
            accountOne.setBalance(accountOne.getBalance()+100);
            acountDao.updateById(accountOne);
            System.out.println(accountOne.toString());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @Test
    public void testUpdate(){
        try{
//            System.out.println(acountDao.getAccountByCode(6217003860017895213L));
//            Account login = acountDao.login(6217003860017895213l);
            acountDao.update(50000, 6217003860017895213l, "add");
            System.out.println(acountDao.login(6217003860017895213l));

        }catch (Exception e) {
            e.printStackTrace();
        }
    }

    @Test
    public void testUpdatePwd(){

        try{
            Account account = new Account();
            account.setCardno(6217003860019691452L);
            account.setPassword("123456");
            acountDao.updatePwd(account);
            acountDao.selectList(null).forEach(accounts-> System.out.println(accounts));
        }catch(Exception e){
            e.printStackTrace();
        }
    }
}
