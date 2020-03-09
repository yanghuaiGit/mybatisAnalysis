package com.example.mybatisexample.domain.entity.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.Date;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    private Long uId;

    /**
     * 姓名
     */
    private String uName;

    /**
     * 1男性2女性
     */
    private Integer sex;

    /**
     * 年龄
     */
    private Integer age;

    /**
     * 创建时间
     */
    private Date createtime;

    /**
     * 修改时间
     */
    private Date modifyTime;


}