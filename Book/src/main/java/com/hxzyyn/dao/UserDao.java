package com.hxzyyn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzyyn.entity.User;

import java.util.List;

public interface UserDao  extends BaseMapper<User> {
    /**
     * 登录
     * @param user
     * @return
     */
    User login(User user);

    /**
     * 查询全部
     * @return
     */
    List<User> findAll();

}
