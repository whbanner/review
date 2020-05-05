package com.example.config;

import com.example.info.JdbcInfo;
import com.example.mapper.UserMapper;
import org.apache.ibatis.session.SqlSessionFactory;
import org.mybatis.spring.SqlSessionFactoryBean;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.io.support.PathMatchingResourcePatternResolver;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

import javax.annotation.Resource;
import javax.sql.DataSource;

@Configuration
public class DataConfig {

    @Resource
    private JdbcInfo jdbcInfo;

    @Bean
    public DataSource dataSource(){
        //spring的
        DriverManagerDataSource dataSource =new DriverManagerDataSource();
        dataSource.setDriverClassName(jdbcInfo.getDriver());
        dataSource.setUrl(jdbcInfo.getUrl());
        dataSource.setUsername(jdbcInfo.getUsername());
        dataSource.setPassword(jdbcInfo.getPassword());
        return dataSource;
    }

    @Bean
    public SqlSessionFactory sqlSessionFactory() throws Exception {
        SqlSessionFactoryBean factoryBean = new SqlSessionFactoryBean();
        factoryBean.setDataSource(dataSource());
        //mapper查出来的数据映射到那个包下的类 UserMapper--->User
        factoryBean.setTypeAliasesPackage(jdbcInfo.getTypeAliasesPackage());
        SqlSessionFactory sqlSessionFactory = factoryBean.getObject();
        //需要将UserMapper加入的全局 相当于xml中加入全局的配置
        sqlSessionFactory.getConfiguration().addMapper(UserMapper.class);



        return sqlSessionFactory;
    }

    @Bean
    public UserMapper userMapper() throws Exception {
        SqlSessionTemplate sqlSessionTemplate = new SqlSessionTemplate(sqlSessionFactory());
        return sqlSessionTemplate.getMapper(UserMapper.class);
    }

}
