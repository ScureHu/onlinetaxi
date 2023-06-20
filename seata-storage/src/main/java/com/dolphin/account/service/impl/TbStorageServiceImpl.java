package com.dolphin.account.service.impl;

import com.baomidou.mybatisplus.core.conditions.update.LambdaUpdateWrapper;
import com.dolphin.account.entity.TbStorage;
import com.dolphin.account.mapper.TbStorageMapper;
import com.dolphin.account.service.ITbStorageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

/**
 * @auther xxxx
 * @create 2023-06-20 15:07:32
 * @describe 服务实现类
 */
@Service
@Slf4j
public class TbStorageServiceImpl extends ServiceImpl<TbStorageMapper, TbStorage> implements ITbStorageService {

    @Override
    public void deduct(String code, Integer count) {
        log.info("开始扣减库存");
        try {
            LambdaUpdateWrapper<TbStorage> update = new LambdaUpdateWrapper<>();
            update.eq(TbStorage::getCommodityCode, code);
            update.setSql("count = count - " + count);
            this.update(update);
        } catch (Exception e) {
            throw new RuntimeException("扣减库存失败，可能是库存不足！", e);
        }
        log.info("扣减库存成功");
    }
}
