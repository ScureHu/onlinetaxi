package com.dolphin.entity;

import com.baomidou.mybatisplus.annotation.TableName;
import com.baomidou.mybatisplus.annotation.TableField;

import java.io.Serializable;

import com.fasterxml.jackson.annotation.JsonInclude;

/**
 * @auther xxxx
 * @create 2023-06-20 14:44:22
 * @describe 实体类
 */
@TableName("demo1")
@JsonInclude(JsonInclude.Include.NON_NULL)
public class Demo1 implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableField("name")
    private String name;

    @TableField("age")
    private String age;


    public String getName() {
        return name;
    }

    public Demo1 setName(String name) {
        this.name = name;
        return this;
    }

    public String getAge() {
        return age;
    }

    public Demo1 setAge(String age) {
        this.age = age;
        return this;
    }

    @Override
    public String toString() {
        return "Demo1{" +
                "name=" + name +
                ", age=" + age +
                "}";
    }
}