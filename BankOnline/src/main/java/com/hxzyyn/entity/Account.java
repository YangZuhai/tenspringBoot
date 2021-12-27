package com.hxzyyn.entity;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

/**
 * @author lulei
 * @date 2021年12月15日 10:07:53
 */

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Account {

    @TableId(value = "cardno")
    private long cardno;
    private String password;
    private double balance;
    private int status;


}
