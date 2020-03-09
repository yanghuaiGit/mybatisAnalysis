package com.example.tkmybatis.mapper.custom.user;

import org.apache.ibatis.annotations.SelectProvider;
import tk.mybatis.mapper.annotation.RegisterMapper;

import java.util.List;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/12
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

@RegisterMapper
public interface MyBatchUpdateMapper<T> {

    @SelectProvider(type = MyBatchUpdateProvider.class, method = "dynamicSQL")
    void batchUpdate(List<T> list);
}
