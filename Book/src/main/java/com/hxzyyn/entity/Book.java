package com.hxzyyn.entity;


import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.util.Date;


@Data
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Accessors(chain = true)
public class Book {


   private int id;
   private String name;

   private String author;
   private String publish;
   private Date publicshdate;

   private int page;

   private double price;

   private String content;
}
