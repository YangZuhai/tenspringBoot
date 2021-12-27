package com.hxzyyn;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hxzyyn.dao.RecordDao;
import com.hxzyyn.entity.Record;
import com.hxzyyn.utils.PageTwo;
import com.hxzyyn.utils.PageUtils;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;

@SpringBootTest
public class TestRecordPage {

    @Autowired
    private PageTwo pageTwo;

    @Autowired
    private RecordDao recordDao;

    @Autowired
    private PageUtils pageUtils;

    @Test
    public void testRecordPage() {
        pageTwo.setCurrPageNo(1);
        pageTwo.setPageSize(5);
        QueryWrapper<Record> wrapper = new QueryWrapper<>();
//        wrapper.eq("id",1);
        IPage<Record> recordIPage = pageUtils.page(recordDao, pageTwo, wrapper);
        recordIPage.getRecords().forEach(record -> System.out.println("分页数据:" + record));
        System.out.println("数据总条数:" + pageTwo.getNumberAll());
        System.out.println("总页数:" + pageTwo.getPageAll());
        System.out.println("总页数:"+recordIPage.getPages());
        pageTwo.setStartList(new ArrayList<Integer>());
        pageTwo.setAllPageStart(pageTwo.getCurrPageNo(), pageTwo.getPageAll());
        for (Integer integer : pageTwo.getStartList()) {
            System.out.println("迭代页码"+integer);
        }
    }

}
