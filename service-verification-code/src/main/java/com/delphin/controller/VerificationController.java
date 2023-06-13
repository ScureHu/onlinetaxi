package com.delphin.controller;

import com.delphin.internalcommon.dto.ResponseResult;
import com.delphin.service.VerificationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/verify-code")
public class VerificationController {

    @Autowired
    VerificationService verificationService;

    @GetMapping("/generate/{identity}/{phoneNumber}")
    public ResponseResult generate(@PathVariable("identity") int identity,
                                   @PathVariable("phoneNumber") String phoneNumber) {
        return verificationService.generate(identity, phoneNumber);
    }
}
