package com.dolphin.order.service.impl;

import com.dolphin.order.entity.TbOrder;
import com.dolphin.order.fegin.AccountClient;
import com.dolphin.order.fegin.StorageClient;
import com.dolphin.order.mapper.TbOrderMapper;
import com.dolphin.order.service.ITbOrderService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import feign.FeignException;
import io.seata.spring.annotation.GlobalTransactional;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.Date;

/**
 * @auther xxxx
 * @create 2023-06-20 14:56:05
 * @describe 服务实现类
 */
@Service
@Slf4j
public class TbOrderServiceImpl extends ServiceImpl<TbOrderMapper, TbOrder> implements ITbOrderService {

    @Autowired
    private AccountClient accountClient;

    @Autowired
    private StorageClient storageClient;

    @Override
    @GlobalTransactional
    public ResponseEntity<Integer> createOrder(TbOrder order) {
        // 创建订单
        order.setCreateTime(new Date());
        this.save(order);
        try {
            // 扣用户余额
            accountClient.deduct(order.getUserId(), order.getMoney());
//             int i=1/0;
            // 扣库存
            storageClient.deduct(order.getCommodityCode(), order.getCount());

        } catch (FeignException e) {
            log.error("下单失败，原因:{}", e.contentUTF8(), e);
            throw new RuntimeException(e.contentUTF8(), e);
        }
        return ResponseEntity.ok(order.getId());
    }
}
