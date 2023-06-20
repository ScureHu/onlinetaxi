package com.delphin.internalcommon.dto;

import com.delphin.internalcommon.constant.CommonStatusEnum;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
    private static final long serialVersionUID = -2073390651767969040L;

    private int code;
    private String message;
    private T data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    /**
     * 返回成功数据（status：1）
     *
     * @param data 数据内容
     * @param <T>  数据类型
     * @return ResponseResult实例
     */
    public static <T> ResponseResult success(T data) {
        ResponseResult result = new ResponseResult();
        result.setCode(CommonStatusEnum.SUCCESS.getCode());
        result.setMessage(CommonStatusEnum.SUCCESS.getValue());
        result.setData(data);
        return result;
    }

    /**
     * 返回错误数据（status：500）
     *
     * @param data 错误内容
     * @param <T>  数据类型
     * @return ResponseResult实例
     */
    public static <T> ResponseResult fail(T data) {
        ResponseResult result = new ResponseResult();
        result.setCode(CommonStatusEnum.INTERNAL_SERVER_EXCEPTION.getCode());
        result.setMessage(CommonStatusEnum.INTERNAL_SERVER_EXCEPTION.getValue());
        result.setData(data);
        return result;
    }

    /**
     * 自定义返回错误数据
     *
     * @param code    错误代码
     * @param message 错误消息
     * @return ResponseResult实例
     */
    public static ResponseResult fail(int code, String message) {
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMessage(message);
        return result;
    }

    /**
     * @param code    错误代码
     * @param message 错误消息
     * @param data    错误内容
     * @return ResponseResult实例
     */
    public static ResponseResult fail(int code, String message, String data) {
        ResponseResult result = new ResponseResult();
        result.setCode(code);
        result.setMessage(message);
        result.setData(data);
        return result;
    }
}
