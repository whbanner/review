package com.wh.config;


import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.wh.consumeraction")
@PropertySource("classpath:/consumer.properties")
@ComponentScan(value = {"com.wh.consumeraction"})
public class ConsumerConfig {
}
