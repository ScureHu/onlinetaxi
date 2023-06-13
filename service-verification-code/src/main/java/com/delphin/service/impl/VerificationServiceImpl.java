package com.delphin.service.impl;

import com.delphin.internalcommon.dto.ResponseResult;
import com.delphin.internalcommon.dto.VerifyCodeResponse;
import com.delphin.service.VerificationService;
import org.springframework.stereotype.Service;

@Service
public class VerificationServiceImpl implements VerificationService {

    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber) {
        //安全检测 不能重复发送
        //redis 1分钟发了3次,限制5分钟不能发。1小时发了10次，24小时不能再发送
        //纯数字操作 加速验证码生成 比字符串截取提升10倍效率
        String code = String.valueOf((Math.random() * 9 + 1) * Math.pow(10, 5));
        VerifyCodeResponse codeResponse = new VerifyCodeResponse();
        codeResponse.setCode(code);

        return ResponseResult.success(codeResponse);
    }

    public ResponseResult verify(int identity, String phoneNumber,String code){
        return null;
    }
}
