package com.example.mybatisexample;

import com.example.mybatisexample.controller.TestController;
import com.example.mybatisexample.domain.entity.user.User;
import com.example.mybatisexample.mapper.user.UserMapper;
import com.example.mybatisexample.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mybatis.spring.annotation.MapperScan;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;
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
//    @Transactional
    void contextLoads() throws InterruptedException {
        testController.test();
  //      userService.update(1L);
    }

    @Test
    public void test1() throws IOException {
        String resource = "mybatis-config.xml";
        InputStream inputStream = Resources.getResourceAsStream(resource);

        // 1、获取sqlSessionFactory对象
        SqlSessionFactory sqlSessionFactory = new SqlSessionFactoryBuilder().build(inputStream);
        // 2、获取sqlSession对象
        SqlSession openSession = sqlSessionFactory.openSession();
        try {
            // 3、获取接口的实现类对象，会为接口自动的创建一个代理对象，代理对象去执行增删改查方法
            UserMapper mapper = openSession.getMapper(UserMapper.class);
            // 4、执行增删改查方法
            List<User> dept = mapper.select();
            System.out.println(dept);
        } finally {
            openSession.close();
        }
    }

}


