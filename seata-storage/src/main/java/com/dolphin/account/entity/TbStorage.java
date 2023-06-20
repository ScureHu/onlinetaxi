package com.dolphin.account.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @auther xxxx
 * @create 2023-06-20 15:07:32
 * @describe 实体类
 */
@TableName("tb_storage")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TbStorage implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("commodity_code")
    private String commodityCode;

    @TableField("count")
    private Integer count;


    public Integer getId() {
        return id;
    }

    public TbStorage setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getCommodityCode() {
        return commodityCode;
    }

    public TbStorage setCommodityCode(String commodityCode) {
        this.commodityCode = commodityCode;
        return this;
    }

    public Integer getCount() {
        return count;
    }

    public TbStorage setCount(Integer count) {
        this.count = count;
        return this;
    }

    @Override
    public String toString() {
        return "TbStorage{" +
                "id=" + id +
                ", commodityCode=" + commodityCode +
                ", count=" + count +
                "}";
    }
}