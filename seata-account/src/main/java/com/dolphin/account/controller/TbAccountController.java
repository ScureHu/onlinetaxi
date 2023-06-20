package com.dolphin.account.controller;


import com.dolphin.account.entity.TbAccount;
import com.dolphin.account.service.ITbAccountService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @auther xxxx
 * @create 2023-06-20 15:03:21
 * @describe 前端控制器
 */
@RestController
@RequestMapping("/account")
public class TbAccountController {

    @Autowired
    private ITbAccountService iTbAccountService;

    @GetMapping("/{userId}/{money}")
    public ResponseEntity deduct(@PathVariable("userId") String userId, @PathVariable("money") Integer money) {
        iTbAccountService.deduct(userId, money);
        return ResponseEntity.ok().build();
    }


    @PostMapping("/creatUser")
    public ResponseEntity deduct(@RequestBody TbAccount tbAccount) {
        iTbAccountService.save(tbAccount);
        return ResponseEntity.ok().build();
    }
}

