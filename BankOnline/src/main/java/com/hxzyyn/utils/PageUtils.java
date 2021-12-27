package com.hxzyyn.utils;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.hxzyyn.dao.RecordDao;
import com.hxzyyn.entity.Record;

import javax.xml.ws.RequestWrapper;

public class PageUtils {

    public IPage<Record> page(RecordDao recordDao, PageTwo page,QueryWrapper<Record> wrapper) {
        IPage<Record> pages = null;
        try {
            IPage<Record> recordPage = new Page<>(page.getCurrPageNo(),page.getPageSize()); //分页对象
//            QueryWrapper<Record> wrapper = new QueryWrapper<Record>();
//            wrapper.between("balance",0,4500);
            pages = recordDao.selectPage(recordPage, wrapper);
//            数据总条数
//            pages.getTotal();
//            获取总页数
            page.setPageAll((int) pages.getTotal());
        } catch (Exception e) {
            e.printStackTrace();
        }
        return pages;
    }

}
