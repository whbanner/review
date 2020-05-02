package com.wh.aop.conifg;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@Configuration
@ComponentScan("com.wh.aop")
@EnableAspectJAutoProxy
public class SpringConfig {

}
