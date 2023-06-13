package com.delphin.internalcommon.dto;

import java.io.Serializable;

public class ResponseResult<T> implements Serializable {
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

    public static <D> ResponseResult<D> success(D data) {
        ResponseResult responseResult = new ResponseResult();
        responseResult.setCode(10000);
        responseResult.setData(data);
        responseResult.setMessage("success");
        return responseResult;
    }
}
