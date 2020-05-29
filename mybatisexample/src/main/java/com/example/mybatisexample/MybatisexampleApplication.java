package com.example.mybatisexample;

import com.example.mybatisexample.mapper.user.Other1Mapper;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;


@MapperScan(basePackages = "com.example.mybatisexample.mapper")
@SpringBootApplication
public class MybatisexampleApplication {

    public static void main(String[] args) {
        ConfigurableApplicationContext run = SpringApplication.run(MybatisexampleApplication.class, args);
        // mybatis会将包下所有的接口都生成对应的代理类  Other1Mapper 没有对应的xml文件 调用就会报错的
        //在启动的时候 mybatis会解析xml文件里的 namaspace 获取到对应的接口 并生成代理类  此时xml对应的接口的代理类就已经实例化了  MapperProxy是FactoryBean 是延迟加载的
        // FactoryBean 是延迟加载的 因此如果 这个接口 没有 对应的 xml文件 是没有被实例化 还是一个 FactoryBean 你第一次获取 就是FactoryBean 获取了 走的不是有xml的实例化 这儿没仔细看
//        Other1Mapper bean = run.getBean(Other1Mapper.class);
//        bean.selectAll();
    }

}
