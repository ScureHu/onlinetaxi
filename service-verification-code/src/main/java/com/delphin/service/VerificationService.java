package com.delphin.service;

import com.delphin.internalcommon.dto.ResponseResult;
import com.delphin.internalcommon.dto.VerifyCodeResponse;


public interface VerificationService {
    ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber);
}
