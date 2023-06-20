package com.dolphin.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @auther xxxx
 * @create 2023-06-20 14:56:05
 * @describe 实体类
 */
@TableName("tb_order")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TbOrder implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("user_id")
    private String userId;

    @TableField("commodity_code")
    private String commodityCode;

    @TableField("count")
    private Integer count;

    @TableField("money")
    private Integer money;

    @TableField("create_time")
    private Date createTime;


    public Integer getId() {
        return id;
    }

    public TbOrder setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getUserId() {
        return userId;
    }

    public TbOrder setUserId(String userId) {
        this.userId = userId;
        return this;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public TbOrder setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public TbOrder setCount(Integer count) {
        this.count = count;
        return this;
    }

    public Integer getMoney() {
        return money;
    }

    public TbOrder setMoney(Integer money) {
        this.money = money;
        return this;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public TbOrder setCreateTime(Date createTime) {
        this.createTime = createTime;
        return this;
    }

    @Override
    public String toString() {
        return "TbOrder{" +
                "id=" + id +
                ", userId=" + userId +
                ", commodityCode=" + commodityCode +
                ", count=" + count +
                ", money=" + money +
                ", createTime=" + createTime +
                "}";
    }
}