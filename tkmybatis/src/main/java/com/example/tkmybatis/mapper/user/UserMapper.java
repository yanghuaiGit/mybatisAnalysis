package com.example.tkmybatis.mapper.user;

import com.example.tkmybatis.domain.entity.user.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import tk.mybatis.mapper.common.Mapper;

import java.util.List;

public interface UserMapper extends Mapper<User> {
    Logger LOGGER = LoggerFactory.getLogger(UserMapper.class);



    List<User> select();

    default boolean updateSuccess(User user) {
        int result = updateByPrimaryKeySelective(user);

        LOGGER.info("result {},更新结果 {}", result, result == 1);
        if (result == 0) {
            throw new RuntimeException("更新失败!");
        }
        return result == 1;
    }
}