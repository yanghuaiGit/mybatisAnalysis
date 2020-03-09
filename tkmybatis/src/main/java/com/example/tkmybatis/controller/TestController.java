package com.example.tkmybatis.controller;


import com.example.tkmybatis.domain.entity.user.User;
import com.example.tkmybatis.mapper.custom.user.MyBatchUpdateMapper;
import com.example.tkmybatis.mapper.user.UserMapper;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;
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
public class TestController {

    @Resource
    private UserMapper userMapper;

    @Resource
    private MyBatchUpdateMapper myBatchUpdateMapper;

    @GetMapping("/saveAndUpdate")
    public User test() {

        User user = User.builder()
                .age(1000)
                .sex(1)
                .uName("用户1")
                .build();

        userMapper.insertSelective(user);

        user = userMapper.selectByPrimaryKey(user.getUId());

        user.setUName("用户" + user.getUId());

        userMapper.updateSuccess(user);

        return user;
    }

    @GetMapping("batchUpdate")
    public void batchUpdate() {

        List<User> list = userMapper.selectAll();
        list.forEach(v -> v.setUName("用户:" + v.getUId()));

        myBatchUpdateMapper.batchUpdate(list);

    }

}
