package com.hxzyyn.entity;

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
public class User {

   private int id;
   private String name;
   private String password;
   private int age;
   private String nickname;
   private int usertype;



}
