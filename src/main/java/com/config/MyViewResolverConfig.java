package com.config;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.View;
import org.springframework.web.servlet.ViewResolver;
import org.springframework.web.servlet.config.annotation.ViewControllerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import java.util.Locale;

/**
  自定义视图解析器: （也可以不写静态内部类，当前类直接实现接口也可）
    1.类上加@Configuration注解
    2.编写静态内部类，作为视图解析器，实现ViewResolver接口
    3.重写resolveViewName()方法
    4.将bean注册到容器中 @Bean

   课外：
      视图解析器：MyViewResolverConfig类是通过自己加上@Configuration注解，表示是一个配置类，以静态内部类方式定义了自定义视图解析器，并注册bean
      地区解析器：MyLocaleResolver类是直接实现接口，不是一个配置类，以在MyMvcConfig配置类中注册了bean
   总结：
     两种方式都可以，但是@bean注册bean必须在一个加了@Configuration注解的配置类中进行注册，才被识别是配置类，springboot自动装配
 */
// 注意：如果你想要自定义定制化功能，只要写此组件，然后交给SpringBoot,它会帮我们自动装配；扩展springMVC   DispatcherServlet
@Configuration
public class MyViewResolverConfig {


    // 步骤一：写一个静态内部类，作为视图解析器；需实现ViewResolver接口
    public static class MyViewResolver implements ViewResolver {

        @Override
        public View resolveViewName(String s, Locale locale) throws Exception {
            return null;
        }
    }

    // 步骤二：@Bean将视图解析器放到bean中 （把此bean注册到容器中）
    @Bean
    public ViewResolver myViewResolver(){
        return new MyViewResolver();
    }
}


