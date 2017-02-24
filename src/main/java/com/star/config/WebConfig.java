package com.star.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.multipart.MultipartResolver;
import org.springframework.web.multipart.support.StandardServletMultipartResolver;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.DefaultServletHandlerConfigurer;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
import org.springframework.web.servlet.view.InternalResourceViewResolver;

import java.io.IOException;

/**
 * Created by hp on 2017/2/24.
 */
@Configuration
@EnableWebMvc  //启用注解驱动的SpringMVC，等同于<mvc:annotation-driver>
@ComponentScan("com.star")
public class WebConfig extends WebMvcConfigurerAdapter{
    //配置视图解析器、静态资源转发器、web组件的bean等
    //继承WebMvcConfigurerAdapter可以使用其静态资源处理方法
    @Bean
    public ViewResolver viewResolver(){
        InternalResourceViewResolver resolver=new InternalResourceViewResolver();
        resolver.setPrefix("/WEB-INF/views/");
        resolver.setSuffix(".jsp");
        return resolver;
    }

    //将静态资源的请求转发到Servlet容器处理，而不是DispatcherServlet处理
    @Override
    public void configureDefaultServletHandling(DefaultServletHandlerConfigurer configurer) {
        configurer.enable();
    }

    //配置multipart解析器
    //具体参数的配置在AbstractAnnotationConfigDispatcherServletInitializer的方法
    //customizeRegistration(Dynamic registration)方法或web.xml中设置
    @Bean
    public MultipartResolver multipartResolver() throws IOException{
        return new StandardServletMultipartResolver();
    }




}
