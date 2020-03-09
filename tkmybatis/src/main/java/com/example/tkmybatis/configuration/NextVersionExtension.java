package com.example.tkmybatis.configuration;

import tk.mybatis.mapper.version.NextVersion;
import tk.mybatis.mapper.version.VersionException;

import java.sql.Timestamp;
import java.util.Date;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/11
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class NextVersionExtension implements NextVersion {
    public NextVersionExtension() {
    }

    public Object nextVersion(Object current) throws VersionException {
        if (current == null) {
            throw new VersionException("当前版本号为空!");
        } else if (current instanceof Integer) {
            return (Integer) current + 1;
        } else if (current instanceof Long) {
            return (Long) current + 1L;
        } else if (current instanceof Timestamp) {
            return new Timestamp(System.currentTimeMillis());
        } else if (current instanceof Date) {
            return new Date();
        } else {
            throw new VersionException("XyNextVersion 只支持 Integer, Long, java.sql.Timestamp,java.util.Date 类型的版本号，如果有需要请自行扩展!");
        }
    }
}
