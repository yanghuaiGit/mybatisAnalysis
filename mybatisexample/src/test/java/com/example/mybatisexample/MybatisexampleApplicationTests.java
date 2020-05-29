package com.example.mybatisexample;

import com.example.mybatisexample.controller.TestController;
import com.example.mybatisexample.mapper.user.UserMapper;
import com.example.mybatisexample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;


@Slf4j
@RunWith(SpringRunner.class) // SpringJUnit支持，由此引入Spring-Test框架支持！
@SpringBootTest(classes = MybatisexampleApplication.class)
@MapperScan({"com.example.mybatisexample.mapper"})//
class MybatisexampleApplicationTests {

    @Resource
    private UserService userService;

    @Resource
    private TestController testController;

    @Test
    @Transactional
    void contextLoads() throws InterruptedException {
        testController.test();
//        userService.update(1L);
    }

}


