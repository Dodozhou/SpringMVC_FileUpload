package com.star.initializer;

import com.star.config.RootConfig;
import com.star.config.WebConfig;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import javax.servlet.MultipartConfigElement;
import javax.servlet.ServletRegistration;
import javax.servlet.http.HttpServletRequest;

/**
 * Created by hp on 2017/2/24.
 * 通过abstractAnnotationConfigDispatcherServletInitializer来配置DispatcherServlet是传统
 * web.xml方式的替代方案。如果愿意，可以同时包含web.xml和该类，但这没有必要。
 * 该方式来配置servlet，只支持Servlet3.0的服务器，如Tomcat7或更高版本。
 */
public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {
    //配置servlet映射路径，它会将一个或多个路径映射到DispatcherServlet上。
    @Override
    protected String[] getServletMappings() {
        return new String[]{"/"};
    }

    //指定Spring中的另一个上下文（ContextLoderListener创建的上下文）加载配置的文件
    //该配置类配置驱动应用后端的中间层和数据层组件的bean
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[]{RootConfig.class};
    }

    //该方法指定了DispatcherServlet加载配置的文件
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    //配置文件上传的具体参数，如保存路径、文件大小等等
    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setMultipartConfig(
                new MultipartConfigElement("",2000000,10000000,0));
    }
}
