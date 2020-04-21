package com.example.mybatisexample.controller;

import com.example.mybatisexample.domain.entity.user.User;
import com.example.mybatisexample.mapper.user.OtherMapper;
import com.example.mybatisexample.mapper.user.UserMapper;
import lombok.extern.slf4j.Slf4j;
import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
import java.io.IOException;
import java.io.InputStream;
import java.util.List;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/10
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
@RestController
@RequestMapping("/test")
@Slf4j
public class TestController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private OtherMapper otherMapper;

    @GetMapping("/select")
    public List<User> test() {
//        otherMapper.selectAll();
//        System.out.println(otherMapper.selectAll());

        List<User> select = userMapper.select();
        log.info("list {}", select);

        List<User> users = userMapper.selectById(1L);
        log.info("user {}", users);
        return select;
    }


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
