package com.hxzyyn;

import com.hxzyyn.dao.UserDao;
import com.hxzyyn.entity.User;
import com.hxzyyn.service.UserService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;

public class TestUserDao  extends  TestMain{


    private final UserDao userDao;

    @Autowired
    public TestUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    @Autowired
    private UserService userService;


    @Test
    public void testFindAll(){
       try{
//           System.out.println(userDao.selectList(null));
//           System.out.println(userDao.login(new User(0, "", "", 0, null, 0)));
//           userService.findAll().forEach(System.out::println);
       }catch(Exception e){
           e.printStackTrace();
       }

    }

}
