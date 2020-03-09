package com.example.tkmybatis.domain.vo;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/10
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */
public class TestVo {
    private Long money;

    public TestVo() {
    }

    public TestVo(Long money) {
        this.money = money;
    }

    public Long getMoney() {
        return money;
    }

    public void setMoney(Long money) {
        this.money = money;
    }
}
