package com.hxzyyn.service;

import com.hxzyyn.entity.Record;


import java.util.List;

/**
 * @author lulei
 * @date 2021年12月17日 14:51:57
 */


public interface RecordService {

    List<Record> findAll();

    void addRecordData(Record record);
}
