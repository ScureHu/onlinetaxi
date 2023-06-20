package com.delphin.service.impl;

import com.delphin.internalcommon.constant.CommonStatusEnum;
import com.delphin.internalcommon.constant.IdentityConstant;
import com.delphin.internalcommon.constant.VerifyCodeConstant;
import com.delphin.internalcommon.dto.ResponseResult;
import com.delphin.internalcommon.dto.verificationcode.response.VerifyCodeResponse;
import com.delphin.service.VerificationService;
import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.BoundValueOperations;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.stereotype.Service;

import java.util.concurrent.TimeUnit;

@Service
public class VerificationServiceImpl implements VerificationService {

    @Autowired
    private RedisTemplate<String, String> redisTemplate;

    /**
     * 生成验证码
     *
     * @param identity
     * @param phoneNumber
     * @return
     */
    public ResponseResult<VerifyCodeResponse> generate(int identity, String phoneNumber) {
        //安全检测 不能重复发送
        //redis 1分钟发了3次,限制5分钟不能发。1小时发了10次，24小时不能再发送
        checkSendCodeTimeLimit(phoneNumber);
        //纯数字操作 加速验证码生成 比字符串截取提升10倍效率
        String code = String.valueOf((Math.random() * 9 + 1) * Math.pow(10, 5));
        //操作redis存储生成验证码
        String keyPre = generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;
        BoundValueOperations<String, String> codeRedis = redisTemplate.boundValueOps(key);
        codeRedis.set(code);
        codeRedis.expire(120, TimeUnit.SECONDS);
        //返回数据
        VerifyCodeResponse codeResponse = new VerifyCodeResponse();
        codeResponse.setCode(code);
        return ResponseResult.success(codeResponse);
    }

    /**
     * 校验
     *
     * @param identity
     * @param phoneNumber
     * @param code
     * @return
     */
    public ResponseResult verify(int identity, String phoneNumber, String code) {
        //三档验证
        String keyPre = generateKeyPreByIdentity(identity);
        String key = keyPre + phoneNumber;
        BoundValueOperations<String, String> codeRedis = redisTemplate.boundValueOps(key);
        String redisCode = codeRedis.get();

        if (StringUtils.isNotBlank(code)
                && StringUtils.isNotBlank(redisCode)
                && code.trim().equals(redisCode.trim())) {
            return ResponseResult.success(null);
        } else {
            return ResponseResult.fail(CommonStatusEnum.VERIFY_CODE_ERROR.getCode(), CommonStatusEnum.VERIFY_CODE_ERROR.getValue());
        }
    }

    /**
     * 根据身份类型生成对应的缓存key
     *
     * @param identity
     * @return
     */
    private String generateKeyPreByIdentity(int identity) {
        String keyPre = "";
        if (identity == IdentityConstant.PASSENGER) {
            keyPre = VerifyCodeConstant.PASSENGER_LOGIN_KEY_PRE;
        } else if (identity == IdentityConstant.DRIVER) {
            keyPre = VerifyCodeConstant.DRIVER_LOGIN_KEY_PRE;
        }
        return keyPre;
    }

    /**
     * 判断此手机号发送时限限制
     *
     * @param phoneNumber
     * @return
     */
    private ResponseResult checkSendCodeTimeLimit(String phoneNumber) {
        //判断是否有 限制1分钟，10分钟，24小时。

        return ResponseResult.success("");
    }

    /**
     * 三档验证校验 看设计手册
     *
     * @param phoneNumber
     * @param code
     * @return
     */
    private ResponseResult checkCodeThreeLimit(String phoneNumber, String code) {
        //看流程图

        return ResponseResult.success("");
    }

}
