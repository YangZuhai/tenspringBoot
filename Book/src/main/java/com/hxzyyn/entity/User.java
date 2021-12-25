package com.hxzyyn.entity;


import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
@TableName(value = "user")
public class User {

   @TableId(value = "id",type = IdType.AUTO)
   private int id;
   private String name;
   private String password;
   private int age;
   private String nickname;
   private int usertype;



}
