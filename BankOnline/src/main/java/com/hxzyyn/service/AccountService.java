package com.hxzyyn.service;

import com.hxzyyn.entity.Account;
import org.apache.ibatis.annotations.Param;

/**
 * @author lulei
 * @date 2021年12月15日 11:13:45
 */
public interface AccountService {

    Account login(long cardno);

    double getAccountByCode(long cardno);

    int update( double money, long cardno, String flag);

    void updatePwd(Account account);
}
