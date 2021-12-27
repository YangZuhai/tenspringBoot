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




    @Test
    public void testFindAll(){
       try{
//           System.out.println(userDao.selectList(null));
           System.out.println(userDao.login(new User(1, null, null, 0, null, 0)));
//           userService.findAll().forEach(System.out::println);
       }catch(Exception e){
           e.printStackTrace();
       }

    }

}
