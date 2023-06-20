package com.dolphin.order.service;

import com.dolphin.order.entity.TbOrder;
import com.baomidou.mybatisplus.extension.service.IService;
import org.springframework.http.ResponseEntity;

/**
 * @auther xxxx
 * @create 2023-06-20 14:56:05
 * @describe 服务类
 */
public interface ITbOrderService extends IService<TbOrder> {

    ResponseEntity<Integer> createOrder(TbOrder order);
}
