package com.hxzyyn.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;

/**
 * @author lulei
 * @date 2021年12月15日 10:10:04
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
@TableName(value = "transaction_record")
public class Record {
    @TableId(value = "id",type = IdType.AUTO)
    private int id;
    private long cardno;
    @TableField(value = "transactionDate")
    private Date transactionDate;
    private double expense;
    private double income;
    private double balance;
    @TableField(value = "transactionType")
    private String transactionType;
    private String remark;
}


