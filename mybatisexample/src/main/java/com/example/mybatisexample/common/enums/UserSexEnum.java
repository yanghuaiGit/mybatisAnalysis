package com.example.mybatisexample.common.enums;

import java.util.Arrays;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/12
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */


public enum UserSexEnum {
    MAN(1, "男性"),
    WOMEN(2, "女性");


    private Integer code;
    private String value;


    public static String getValue(int code) {
        return Arrays.stream(UserSexEnum.values())
                .filter(sex -> sex.getCode().equals(code))
                .findFirst()
                .orElseThrow(() -> new RuntimeException("无效的code 【 " + code + " 】"))
                .getValue();
    }

    UserSexEnum(Integer code, String value) {
        this.code = code;
        this.value = value;
    }

    UserSexEnum() {
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }
}
