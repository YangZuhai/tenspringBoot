package com.hxzyyn;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
@MapperScan("com.hxzyyn.dao")
public class BankOnlineApplication {

    public static void main(String[] args) {
        SpringApplication.run(BankOnlineApplication.class, args);
    }

}
