package com.example.tkmybatis.domain.entity.user;

import com.example.tkmybatis.configuration.NextVersionExtension;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import tk.mybatis.mapper.annotation.KeySql;
import tk.mybatis.mapper.annotation.Version;

import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Data
//@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {
    @Column(name = "u_id")
    @Id
    @KeySql(useGeneratedKeys = true)
    private Long uId;

    /**
     * 姓名
     */
    @Column(name = "u_name")
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
    @Column(name = "createTime")
    private Date createtime;

    /**
     * 修改时间
     */
    @Column(name = "modify_time")
    @Version(nextVersion = NextVersionExtension.class)
    private Date modifyTime;


}