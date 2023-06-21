package com.dolphin.order.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.IdType;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @auther xxxx
 * @create 2023-06-21 14:17:37
 * @describe 实体类
 */
@TableName("transaction_log")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class TransactionLog implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "id", type = IdType.AUTO)
    private Integer id;

    @TableField("transaction_id")
    private String transactionId;

    @TableField("log")
    private String log;


    public Integer getId() {
        return id;
    }

    public TransactionLog setId(Integer id) {
        this.id = id;
        return this;
    }

    public String getTransactionId() {
        return transactionId;
    }

    public TransactionLog setTransactionId(String transactionId) {
        this.transactionId = transactionId;
        return this;
    }

    public String getLog() {
        return log;
    }

    public TransactionLog setLog(String log) {
        this.log = log;
        return this;
    }

    @Override
    public String toString() {
        return "TransactionLog{" +
                "id=" + id +
                ", transactionId=" + transactionId +
                ", log=" + log +
                "}";
    }
}