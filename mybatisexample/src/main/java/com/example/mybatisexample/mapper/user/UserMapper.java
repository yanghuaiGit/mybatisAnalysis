package com.example.mybatisexample.mapper.user;

import com.example.mybatisexample.domain.entity.user.User;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;

import java.util.List;


public interface UserMapper {

    List<User> select();

    List<User> selectById(@Param("uId") Long uId);

    void updateById(Long uId,String newName);
}