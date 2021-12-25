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

@TableName(value = "book")
@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Book {

@TableId(value = "id",type = IdType.AUTO)
   private int id;
   private String name;
   @TableField(value = "Author")
   private String author;
   private String publish;
   private Date publicshdate;
   @TableField(value = "Page")
   private int page;
   @TableField(value = "Price")
   private double price;
   @TableField(value = "Content")
   private String content;
}
