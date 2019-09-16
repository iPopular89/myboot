package com.liuxing.controller;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

@SpringBootApplication(scanBasePackages ={"com.liuxing"} )
@MapperScan("com.liuxing.mapper")
@EnableSwagger2
public class MybootApiApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybootApiApplication.class, args);
    }

}
