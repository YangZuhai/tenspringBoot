package com.hxzyyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.hxzyyn.dao.UserDao;
import com.hxzyyn.entity.User;
import com.hxzyyn.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@Transactional
public class UserServiceImpl implements UserService {

    @Autowired
    private UserDao userDao;

    @Override
    public User login(User user) {
//        return (User) userDao.selectList(new QueryWrapper<User>().eq("name","张三"));
        return userDao.login(user);
    }

    @Override
    public List<User> findAll() {
        return userDao.selectList(null);
    }
}
