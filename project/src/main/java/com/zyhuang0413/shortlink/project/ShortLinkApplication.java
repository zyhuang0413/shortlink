package com.zyhuang0413.shortlink.project;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zyhuang
 * Date: 2023/12/31
 * Time: 0:16
 * Description:
 */
@SpringBootApplication
@MapperScan("com.zyhuang0413.shortlink.project.dao.mapper")
public class ShortLinkApplication {
     public static void main(String[] args) {
          SpringApplication.run(SpringApplication.class);
     }
}
