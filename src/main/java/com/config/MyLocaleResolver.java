package com.config;

import org.springframework.util.StringUtils;
import org.springframework.web.servlet.LocaleResolver;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

/**

 SpringBoot扩展MVC——国际化设置 地区解析器
     1.类上加 @Configuration注解
     2.实现 LocaleResolver接口
     3.重写 resolveLocale()与 setLocale()方法
     4.@Bean 自定义组件注册到容器中  （请去MyMvcConfig类中查看对当前类进行的注册）
   —— LocaleResolver 地址解析器接口（通过此设置，实现前端中英文切换：切换读取的properties是英文的还是中文的）

 课外：
   视图解析器：MyViewResolverConfig类是通过自己加上@Configuration注解，表示是一个配置类，以静态内部类方式定义了自定义视图解析器，并注册bean
   地区解析器：MyLocaleResolver类是直接实现接口，不是一个配置类，以在MyMvcConfig配置类中注册了bean
 总结：
   两种方式都可以，但是@bean注册bean必须在一个加了@Configuration注解的配置类中进行注册，才被识别是配置类，springboot自动装配
 */
public class MyLocaleResolver implements LocaleResolver {
    // 解析语言
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        // 获取html页面请求的参数
        String language = request.getParameter("lan");

        // 如果没有就使用默认地址
        Locale locale = Locale.getDefault();

        // 如果请求的链接携带了地区化的参数
        if(StringUtils.hasText(language)){
            // zh_CN：简体中文(中国)   en_US：英语(美国)  字符串切割，得出国家与地区
            String[] area = language.split("_");
            // 国家，地区
            locale = new Locale(area[0],area[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
