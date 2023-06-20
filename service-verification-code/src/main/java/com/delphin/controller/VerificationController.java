package com.delphin.controller;

import com.delphin.internalcommon.dto.ResponseResult;
import com.delphin.internalcommon.dto.verificationcode.request.CodeVerifyRequest;
import com.delphin.service.VerificationService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/verify-code")
@Slf4j
public class VerificationController {

    @Autowired
    VerificationService verificationService;

    @GetMapping("/generate/{identity}/{phoneNumber}")
    public ResponseResult generate(@PathVariable("identity") int identity,
                                   @PathVariable("phoneNumber") String phoneNumber) {
        return verificationService.generate(identity, phoneNumber);
    }

    @PostMapping("/verify")
    public ResponseResult verify(@RequestBody CodeVerifyRequest request) {
        log.info("/verify-code/verify  request:");
        //获取手机号和验证码
        String phoneNumber = request.getPhoneNumber();
        int identity = request.getIdentity();
        String code = request.getCode();

        return verificationService.verify(identity, phoneNumber, code);

    }
}
