package com.example.mybatisexample.mapper.user;

import com.example.mybatisexample.domain.entity.user.User;

import java.util.List;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/21
 * @description 仅仅是为了验证@mapperscan会扫描所有的接口
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public interface Other1Mapper {
    List<User> selectAll();
}
