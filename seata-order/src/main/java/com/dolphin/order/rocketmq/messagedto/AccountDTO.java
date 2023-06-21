package com.dolphin.order.rocketmq.messagedto;

import lombok.Builder;

@Builder
public class AccountDTO {
    private String userId;
    private Integer money;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public Integer getMoney() {
        return money;
    }

    public void setMoney(Integer money) {
        this.money = money;
    }
}
