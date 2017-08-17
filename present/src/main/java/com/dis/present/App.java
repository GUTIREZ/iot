package com.dis.present;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

// @SpringBootApplication 可以代替 @Configuration+@EnableAutoConfiguration+@ComponentScan
// exclude参数可以排除特定的注解 
//@Configuration
// 让spring boot根据类路径中的jar包依赖为当前项目进行自动配置
// spring boot 会自动扫描SpringBootApplication所在包同级及以下包里的bean
//@EnableAutoConfiguration 
//@ComponentScan

@SpringBootApplication
public class App {

    public static void main(String[] args) {
            	SpringApplication.run(App.class, args);
    }
}