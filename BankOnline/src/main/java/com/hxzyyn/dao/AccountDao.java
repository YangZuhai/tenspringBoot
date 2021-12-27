package com.hxzyyn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
//import com.baomidou.mybatisplus.core.mapper.Mapper;
import com.hxzyyn.entity.Account;
import org.apache.ibatis.annotations.Param;

//import org.apache.ibatis.annotations.Param;

/**
 * @author lulei
 * @date 2021年12月15日 11:04:10
 */
public interface AccountDao extends BaseMapper<Account> {

    Account login(long cardno);

    Double getAccountByCode(long cardno);

    int update(@Param("money") double money,@Param("cardno")long cardno,@Param("flag") String flag);

    /**
     * 根据卡号修改密码
     * @param cardno
     */
    void updatePwd(Account account);
}
