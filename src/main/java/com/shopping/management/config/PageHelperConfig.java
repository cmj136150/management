package com.shopping.management.config;

import com.github.pagehelper.PageHelper;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Properties;

@Configuration
public class PageHelperConfig {
    @Bean
    public PageHelper pageHelper(){
        PageHelper pageHelper = new PageHelper();
        Properties p = new Properties();
        //1.offsetAsPageNum: 设置为 true时，会将 RowBounds第一个参数 offset当成 pageNum页码使用 .
        p.setProperty("offsetAsPageNum", "true");
        //2.rowBoundsWithCount: 设置为 true时，使用 RowBounds分页会进行 count查询 .
        p.setProperty("rowBoundsWithCount", "true");
        //3.reasonable ：启用合理化时，如果 pageNum<1会查询第一页，如果 pageNum>pages会查询最后一页。
        p.setProperty("reasonable", "true");
        pageHelper.setProperties(p);
        return pageHelper;
    }
}
