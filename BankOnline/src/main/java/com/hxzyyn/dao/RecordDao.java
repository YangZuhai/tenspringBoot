package com.hxzyyn.dao;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.hxzyyn.entity.Record;

import java.util.List;

/**
 * @author lulei
 * @date 2021年12月17日 10:03:35
 */
public interface RecordDao extends BaseMapper<Record> {

     List<Record> findAll();

     void addRecordData(Record record);
}
