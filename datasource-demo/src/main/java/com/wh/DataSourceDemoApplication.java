package com.wh;


import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.sql.DataSource;
import java.sql.Connection;
import java.sql.SQLException;

@SpringBootApplication
@Slf4j
public class DataSourceDemoApplication implements CommandLineRunner {

    @Autowired
    private DataSource dataSource; //在配置文件中配置为hakari连接池 自动注入的即为hakari连接池


    public static void main(String[] args) {
        SpringApplication.run(DataSourceDemoApplication.class, args);


    }


    public Connection getConnection() throws SQLException {
        return dataSource.getConnection();
    }

//测试100w次连接需要花多长时间
    @Override
    public void run(String... args) throws Exception {
        long start = System.currentTimeMillis();
        for (int i = 0; i < 1000000; i++) {
            Connection connection = getConnection();
            connection.close();
//            System.out.println(i);
        }
        long end = System.currentTimeMillis();
        System.out.println(end - start);
    }
}
