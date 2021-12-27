package com.hxzyyn.service.impl;

import com.hxzyyn.dao.AccountDao;
import com.hxzyyn.entity.Account;
import com.hxzyyn.service.AccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author lulei
 * @date 2021年12月15日 11:14:53
 */
@Service
@Transactional
public class AccountServiceImpl implements AccountService {

    @Autowired
    private AccountDao accountDao;


    @Override
    public Account login(long cardno) {
        return accountDao.login(cardno);

    }

    @Override
    public double getAccountByCode(long caedno) {
        return accountDao.getAccountByCode(caedno);
    }

    @Override
    public int update(double money, long cardno, String flag) {
        return accountDao.update(money, cardno, flag);
    }

    @Override
    public void updatePwd(Account account) {
        accountDao.updatePwd(account);
    }

}
