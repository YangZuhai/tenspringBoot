package com.hxzyyn.config;


import com.hxzyyn.utils.PageTwo;
import com.hxzyyn.utils.PageUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class PageConfig {

    @Bean
    public PageTwo page() {
        return new PageTwo();
    }

    @Bean
    public PageUtils pageUtils(){
        return new PageUtils();
    }

}
