package com.dolphin.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @auther xxxx
 * @create 2023-06-20 15:03:33
 * @describe 实体类
 */
@TableName("tb_account_freeze")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TbAccountFreeze implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "xid", type = IdType.AUTO)
    private String xid;

    @TableField("user_id")
    private Integer userId;

    @TableField("freeze_money")
    private Integer freezeMoney;

    @TableField("state")
    private String state;


    public String getXid() {
        return xid;
    }

    public TbAccountFreeze setXid(String xid) {
        this.xid = xid;
        return this;
    }

    public Integer getUserId() {
        return userId;
    }

    public TbAccountFreeze setUserId(Integer userId) {
        this.userId = userId;
        return this;
    }

    public Integer getFreezeMoney() {
        return freezeMoney;
    }

    public TbAccountFreeze setFreezeMoney(Integer freezeMoney) {
        this.freezeMoney = freezeMoney;
        return this;
    }

    public String getState() {
        return state;
    }

    public TbAccountFreeze setState(String state) {
        this.state = state;
        return this;
    }

    @Override
    public String toString() {
        return "TbAccountFreeze{" +
                "xid=" + xid +
                ", userId=" + userId +
                ", freezeMoney=" + freezeMoney +
                ", state=" + state +
                "}";
    }
}