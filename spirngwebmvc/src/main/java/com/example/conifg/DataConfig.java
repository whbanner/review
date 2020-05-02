package com.example.conifg;

import com.alibaba.druid.pool.DruidDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import javax.annotation.Resource;
import javax.sql.DataSource;
import java.sql.SQLException;


@Configuration
public class DataConfig {

    @Resource //同autowired 只不过这个是注入配置文件的 ---> @Injected
    private JDBCInfo jdbcInfo;

    @Bean  //让spring管理DataSource
    public DataSource getDataSource() throws SQLException {
        //spring的
//        DriverManagerDataSource dataSource =new DriverManagerDataSource();
        //durid的DataSource
        DruidDataSource dataSource = new DruidDataSource();
        dataSource.setDriverClassName(jdbcInfo.getDriver());
        dataSource.setUrl(jdbcInfo.getUrl());
        dataSource.setUsername(jdbcInfo.getUsername());
        dataSource.setPassword(jdbcInfo.getPassword());
        dataSource.setConnectionProperties(jdbcInfo.getConnectionProperties());
        dataSource.setFilters(jdbcInfo.getFilters());
        return dataSource;
    }

    @Bean
    public JdbcTemplate getJDBCTemplate(DataSource dataSource){
        return new JdbcTemplate(dataSource);
    }
}
