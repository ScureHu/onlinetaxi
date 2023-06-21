package com.dolphin.order.service.impl;

import com.dolphin.order.entity.TransactionLog;
import com.dolphin.order.mapper.TransactionLogMapper;
import com.dolphin.order.service.ITransactionLogService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @auther xxxx
 * @create 2023-06-21 14:17:37
 * @describe 服务实现类
 */
@Service
public class TransactionLogServiceImpl extends ServiceImpl<TransactionLogMapper, TransactionLog> implements ITransactionLogService {

    @Transactional
    @Override
    public void saveTransaction(TransactionLog transaction) {
        this.save(transaction);
    }
}
