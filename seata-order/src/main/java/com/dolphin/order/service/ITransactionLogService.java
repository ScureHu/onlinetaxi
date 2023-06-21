package com.dolphin.order.service;

import com.dolphin.order.entity.TransactionLog;
import com.baomidou.mybatisplus.extension.service.IService;

/**
 * @auther xxxx
 * @create 2023-06-21 14:17:37
 * @describe 服务类
 */
public interface ITransactionLogService extends IService<TransactionLog> {

    void saveTransaction(TransactionLog transaction);
}
