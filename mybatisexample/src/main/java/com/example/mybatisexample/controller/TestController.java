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
    public List<User> test() throws InterruptedException {
//        otherMapper.selectAll();
//        System.out.println(otherMapper.selectAll());

        List<User> select = userMapper.selectById(1L);
        log.info("list {}", select);

        //
        new Thread(() -> {
            List<User> users = userMapper.selectById(1L);
            log.info("user {}", users);

            userMapper.updateById(users.get(0).getUId(), "22222");

            users = userMapper.selectById(1L);
            log.info("user {}", users);

        }).start();

        Thread.sleep(4000);
        List<User> users = userMapper.selectById(1L);
        //主线程不会查到上面异步线程更新的值 因为sqlsession的缓存是根据thread来的
        log.info("user {}", users);

        return select;
    }




}
