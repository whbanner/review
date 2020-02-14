package com.wh;

import org.apache.log4j.Logger;

public class LogDemo {

    private static Logger logger = Logger.getLogger(LogDemo.class);

    public static void main(String[] args) throws Exception {
        // debug级别的信息
        logger.debug("This is debug message.");
        // info级别的信息
        logger.info("This is info message.");
        // error级别的信息
        logger.error("This is error message.");

//        System.out.println(6/0);
    }
}
