package com.zyhuang0413.shortlink.admin;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

/**
 * @author zyhuang
 * Date: 2023/12/23
 * Time: 23:39
 * Description:
 */
@SpringBootApplication
@MapperScan("com.zyhuang0413.shortlink.admin.dao.mapper")
public class ShortLinkAdminApplication {
    public static void main(String[] args) {
        SpringApplication.run(ShortLinkAdminApplication.class);
    }
}
