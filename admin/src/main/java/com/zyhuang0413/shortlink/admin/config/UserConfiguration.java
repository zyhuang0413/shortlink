package com.zyhuang0413.shortlink.admin.config;

import com.zyhuang0413.shortlink.admin.common.biz.user.UserTransmitFilter;
import org.springframework.boot.web.servlet.FilterRegistrationBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.core.RedisTemplate;

/**
 * @author zyhuang
 * Date: 2023/12/29
 * Time: 22:04
 * Description: 用户配置自动装配
 */
@Configuration
public class UserConfiguration {

    /**
     * 用户信息传递过滤器
     */
    @Bean
    public FilterRegistrationBean<UserTransmitFilter> globalUserTransmitFilter(RedisTemplate redisTemplate) {
        FilterRegistrationBean<UserTransmitFilter> registrationFilter = new FilterRegistrationBean<>();
        registrationFilter.setFilter(new UserTransmitFilter(redisTemplate));
        registrationFilter.addUrlPatterns("/*");
        registrationFilter.setOrder(0);
        return registrationFilter;
    }

}
