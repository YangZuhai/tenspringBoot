package com.hxzyyn;

import com.hxzyyn.dao.RecordDao;
import com.hxzyyn.entity.Record;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Date;

/**
 * @author lulei
 * @date 2021年12月17日 14:38:00
 */

@SpringBootTest
public class TestRecordDao {

    @Autowired
    private RecordDao recordDao;


    @Test
    public void testFindAll() {
        recordDao.findAll().forEach(record -> System.out.println(record));

    }

    @Test
    public void testAddData() {
        try {
            Record record = new Record(0, 6217003860017895258L, new Date(), 500, 0, 4500, "消费", null);
            recordDao.addRecordData(record);
            testFindAll();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

}
