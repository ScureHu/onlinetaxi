package com.delphin.internalcommon.dto.verificationcode.response;

import java.io.Serializable;

public class VerifyCodeResponse implements Serializable {
    private String code;

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }
}
