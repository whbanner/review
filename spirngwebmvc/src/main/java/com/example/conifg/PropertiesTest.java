package com.example.conifg;

import java.io.IOException;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public class PropertiesTest {
    /**
     * 之前拿properties并连接mysql
     * @throws IOException
     * @throws ClassNotFoundException
     * @throws SQLException
     */
    public void fun1() throws IOException, ClassNotFoundException, SQLException {
        Properties properties=new Properties();
        properties.load(this.getClass().getResourceAsStream("/mysql.properties"));
        String jdbcDriver;
        String jdbcUrl;
        String username;
        String password;

        jdbcDriver=properties.getProperty("datasource.driver");
        jdbcUrl=properties.getProperty("datasource.url");
        username=properties.getProperty("datasource.username");
        password=properties.getProperty("datasource.password");
        Class.forName(jdbcDriver);
        DriverManager.getConnection(jdbcUrl,username,password);
        return ;

    }
}
