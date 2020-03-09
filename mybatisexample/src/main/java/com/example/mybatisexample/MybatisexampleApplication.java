package com.example.mybatisexample;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;


@MapperScan(basePackages = "com.example.mybatisexample.mapper")
@SpringBootApplication
public class MybatisexampleApplication {

    public static void main(String[] args) {
        SpringApplication.run(MybatisexampleApplication.class, args);
    }

}
