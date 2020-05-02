package com.example.conifg;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.web.WebApplicationInitializer;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.context.support.AnnotationConfigWebApplicationContext;
import org.springframework.web.servlet.DispatcherServlet;

import javax.servlet.ServletContainerInitializer;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.ServletRegistration;
import javax.servlet.annotation.HandlesTypes;

/**
 * servlet 3.0 再web容器启动时留了一个接口javax.servlet.ServletContainerInitializer
 * 会调用这个文件下的/META-INF/services/javax.servlet.ServletContainerInitializer
 * spring 在 里面写了org.springframework.web.SpringServletContainerInitializer (spi)
 * @see org.springframework.web.SpringServletContainerInitializer
 * spring实现了servlet预留的接口并预留spring自己的接口
 * 他继承了
 * @see ServletContainerInitializer servlet预留的接口
 * 这样我们如果有多个 配置需要在web'容器启动时 只要继承spring的留接口
 * @see HandlesTypes （SpringServletContainerInitializer上的注解）
 * 会将 继承WebApplicationInitializer的类传给 Spring留的接口
 * 这样多个配置都可按顺序执行（spring实现的）
 *
 *  在启动web容器时 对所配置webcontext进行初始化
 */
public class WebInit implements WebApplicationInitializer {
    @Override
    public void onStartup(ServletContext servletContext) throws ServletException {
        //web上下文
        AnnotationConfigWebApplicationContext context = new AnnotationConfigWebApplicationContext();
        context.register(WebConfig.class); //将WebConfig加载进来
        context.setServletContext(servletContext);//将ServletContext 加载进来
        context.refresh(); //加载相应的bean到容器中 ，还有beanDefinition外壳信息也是在此加入的
        /**
         * 之前是xml servlet-name+servlet-mapping
         */
        ServletRegistration.Dynamic dispatcher = servletContext.addServlet("dispatcher", new DispatcherServlet(context));
        dispatcher.addMapping("/");//外接请求都达到dispatcherServlet
        dispatcher.setLoadOnStartup(1);//设置优先级 先加载dispatcher

    }
}
