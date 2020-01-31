package com.snowy.bookstore.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.filter.FormContentFilter;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @auther snowy
 * @date 2019/12/6 - 16:05
 */
@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
    /*加载登录拦截器*/
    @Autowired
    LoginHandlerInterceptor loginHandlerInterceptor;

    /*拦截器配置*/
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
                //*加入登录拦截器*//
        registry.addInterceptor(loginHandlerInterceptor)
                //*拦截所有请求*//
                .addPathPatterns("/**")
                //*设置不拦截范围*//
                .excludePathPatterns("/","/index.html","/login","/css/**","/js/**","/img/**");
    }

    /*访问静态资源*/
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("classpath:/static/");
    }


    //设置初始页面
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {

        registry.addViewController("/").setViewName("index");
        registry.addViewController("/index.html").setViewName("index");
        registry.addViewController("/bookarchive").setViewName("bookarchive.html");
        registry.addViewController("/booklending").setViewName("booklending.html");
        registry.addViewController("/bookrenewal").setViewName("bookrenewal.html");
        registry.addViewController("/returnofbooks").setViewName("returnofbooks.html");

    }
    /*添加支持PUT和Delete请求*/
    @Bean
    public FormContentFilter httpPutFormContentFilter() {
        return new FormContentFilter();
    }


}
