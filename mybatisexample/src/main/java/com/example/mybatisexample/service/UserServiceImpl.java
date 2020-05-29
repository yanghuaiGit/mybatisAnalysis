package com.example.mybatisexample.service;


import com.example.mybatisexample.mapper.user.UserMapper;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.UUID;

@Service
public class UserServiceImpl implements UserService {
    @Resource
    private UserMapper userMapper;


    @Override
    @Transactional
    public void update(Long id) {
        userMapper.updateById(id, UUID.randomUUID().toString().substring(0, 8));
    }
}
