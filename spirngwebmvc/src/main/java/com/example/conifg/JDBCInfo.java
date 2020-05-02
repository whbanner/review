package com.example.conifg;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.PropertySource;
import org.springframework.core.env.MutablePropertySources;
import org.springframework.core.env.StandardEnvironment;
import org.springframework.stereotype.Component;

/**
 * 将配置文件交给spring管理
 * 之前是直接new properties
 * @see PropertiesTest
 */
@Component
@PropertySource("classpath:mysql.properties")
public class JDBCInfo {
    /**
     * properties为什么要datasource.username 加个前缀？
     * @see StandardEnvironment#customizePropertySources(MutablePropertySources)
     * 在加载properties先加载系统的
     * 如果重名会加载系统中的同名字符
     */
    @Value("${datasource.driver}")
    private String driver;

    @Value("${datasource.url}")
    private String url;

    @Value("${datasource.username}")
    private String username;

    @Value("${datasource.password}")
    private String password;

    @Value("${mysql.filters}")
    private String filters;

    @Value("${mysql.connectionProperties}")
    private String connectionProperties;

    public String getFilters() {
        return filters;
    }

    public String getConnectionProperties() {
        return connectionProperties;
    }



    public String getDriver() {
        return driver;
    }

    public String getUrl() {
        return url;
    }

    public String getUsername() {
        return username;
    }

    public String getPassword() {
        return password;
    }
}
