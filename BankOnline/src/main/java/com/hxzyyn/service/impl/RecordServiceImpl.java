package com.hxzyyn.service.impl;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.hxzyyn.dao.RecordDao;
import com.hxzyyn.entity.Record;
import com.hxzyyn.service.RecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;
import java.util.Map;

/**
 * @author lulei
 * @date 2021年12月17日 14:52:34
 */

@Service
@Transactional
public class RecordServiceImpl implements RecordService {
    @Autowired
    private RecordDao recordDao;

    @Override
    public List<Record> findAll() {
        return recordDao.findAll();
    }

    @Override
    public void addRecordData(Record record) {
        recordDao.addRecordData(record);
    }
}
