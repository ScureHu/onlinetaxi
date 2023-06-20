package com.delphin.service;

import com.delphin.internalcommon.dto.ResponseResult;
import com.delphin.internalcommon.dto.verificationcode.response.VerifyCodeResponse;


public interface VerificationService {
    ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber);

    ResponseResult verify(int identity, String phoneNumber, String code);
}
