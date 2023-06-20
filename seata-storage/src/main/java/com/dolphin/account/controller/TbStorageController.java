package com.dolphin.account.controller;


import com.dolphin.account.entity.TbStorage;
import com.dolphin.account.service.ITbStorageService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * @auther xxxx
 * @create 2023-06-20 15:07:32
 * @describe 前端控制器
 */
@RestController
@RequestMapping("/storage")
public class TbStorageController {

    @Autowired
    private ITbStorageService storageService;

    /**
     * 扣减库存
     *
     * @param code  商品编号
     * @param count 要扣减的数量
     * @return
     */
    @GetMapping("/{code}/{count}")
    public ResponseEntity deduct(@PathVariable("code") String code, @PathVariable("count") Integer count) {
        storageService.deduct(code, count);
        return ResponseEntity.ok().build();
    }

    @PostMapping("/addProduct")
    public String addProduct(@RequestBody TbStorage tbStorage) {
        storageService.save(tbStorage);
        return "添加成功!";
    }


}

