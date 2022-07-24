package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
    SpringBoot扩展MVC——视图解析器：
         1.类上加 @Configuration注解
         2.实现 WebMvcConfigurer接口
         3.重写 addViewControllers() 方法
         （想要定制什么功能，重写相应的方法即可，如需自己定义具体实现，可重写相关功能！请参考MyViewResolverConfig、MyLocaleResolver）

 ——如想保留SpringBoot扩展MVC定制并进行更多MVC定制（拦截器、格式化程序、视图控制器和其他功能）
   您可以添加自己的@Configuraion类但不可添加 @EnableWebMvc！
     原因：
         ① @EnableWebMvc  此注解会导入DelegatingWebMvcConfiguration类
         ② DelegatingWebMvcConfiguration继承了WebMvcConfigurationSupport类
         ③ WebMvcConfigurationSupport类会让WebMvcAutoConfiguration类失效！！！


 课外：
    视图解析器：MyViewResolverConfig类是通过自己加上@Configuration注解，表示是一个配置类，以静态内部类方式定义了自定义视图解析器，并注册bean
    地区解析器：MyLocaleResolver类是直接实现接口，不是一个配置类，以在MyMvcConfig配置类中注册了bean
 总结：
    两种方式都可以，但是@bean注册bean必须在一个加了@Configuration注解的配置类中进行注册，才被识别是配置类，springboot自动装配
 */

@Configuration
public class MyMvcConfig implements WebMvcConfigurer {

    // 使用官方定义的WebMvcConfigurer中的方法功能，进行定制
    @Override
    public void addViewControllers(ViewControllerRegistry registry) {
        registry.addViewController("/").setViewName("login");
        registry.addViewController("/login.do").setViewName("login");
        registry.addViewController("/dashboard.do").setViewName("dashboard");
    }

    // 自定义国际化组件加载至容器中 ——> 不使用官方的重写方式
    @Bean
    public LocaleResolver localeResolver(){
        return new MyLocaleResolver();
    }

    // 配置登录过滤器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // addPathPatterns：配置拦截的路径 ——全部检查
        // excludePathPatterns：排除拦截路径 ——首页、登录请求、静态资源
        registry.addInterceptor(new LoginHandlerInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns("/login.do","/user/login","/","/css/**","/js/**","/img/**");
    }
}
