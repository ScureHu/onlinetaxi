package com.dolphin.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @auther xxxx
 * @create 2023-06-20 15:03:21
 * @describe 实体类
 */
@TableName("tb_account")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TbAccount implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private String userId;

    @TableField("money")
    private Integer money;


    public Integer getId() {
        return id;
    }

    public TbAccount setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public TbAccount setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public Integer getMoney() {
        return money;
    }

    public TbAccount setMoney(Integer money) {
        this.money = money;
        return this;
    }

    @Override
    public String toString() {
        return "TbAccount{" +
                "id=" + id +
                ", userId=" + userId +
                ", money=" + money +
                "}";
    }
}