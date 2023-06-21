package com.dolphin.order.controller;


import com.dolphin.order.entity.TbOrder;
import com.dolphin.order.service.ITbOrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @auther xxxx
 * @create 2023-06-20 14:56:05
 * @describe 前端控制器
 */
@RestController
@RequestMapping("/order")
public class TbOrderController {

    @Autowired
    private ITbOrderService orderService;

    @PostMapping("/createOrder")
    public ResponseEntity<Integer> createOrder(@RequestBody TbOrder order) {
        return orderService.createOrder(order);
    }


    @PostMapping("/createMQOrder")
    public String createMQOrder(@RequestBody TbOrder order) {
        orderService.createMQOrder(order);
        return "OK";
    }
}

