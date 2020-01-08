package com.wh.conifg;

import org.apache.dubbo.config.spring.context.annotation.EnableDubbo;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@EnableDubbo(scanBasePackages = "com.ease.archiecture.impl")
@PropertySource("classpath:provider.properties")
public class ProviderConfig {
}
