package com.wh.config;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.wh.impl")
@PropertySource("classpath:provider.properties")
public class ProviderConfig {
}
