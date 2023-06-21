package com.dolphin.order.rocketmq;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.dolphin.order.entity.TransactionLog;
import com.dolphin.order.service.ITbOrderService;
import com.dolphin.order.service.ITransactionLogService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.producer.LocalTransactionState;
import org.apache.rocketmq.client.producer.TransactionListener;
import org.apache.rocketmq.common.message.Message;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * 2.1 发送预消息给MQ
 * 2.2 MQ返回是否接收到消息
 * 2.3 执行本地事务
 * 2.4 发送确认消息给MQ 或者回滚消息（如果这里发送消息丢失了，那么MQ会定时去回调我们的服务，根据回查的结果确定是否commit或者rollback）
 */
@Slf4j
@Component
public class OrderTransactionListener implements TransactionListener {
    @Autowired
    private ITbOrderService orderService;

    @Autowired
    private ITransactionLogService transactionLogService;

    /**
     * 发送 half msg 返回send OK后调用的方法
     *
     * @param message
     * @param o
     * @return
     */
    @Override
    public LocalTransactionState executeLocalTransaction(Message message, Object o) {
        log.info("开始执行本地事务");
        LocalTransactionState state;
        try {
            String transactionId = message.getTransactionId();
            //保存事务log
            TransactionLog transaction = new TransactionLog();
            transaction.setTransactionId(transactionId);
            transaction.setLog("执行扣除订单金额");
            transactionLogService.saveTransaction(transaction);
            log.info("本地事务已提交。{}", message.getTransactionId());
            //返回commit后，消息被消费者消费
            state = LocalTransactionState.COMMIT_MESSAGE;

        } catch (Exception e) {
            log.info("执行本地事务失败。{}", e);
            state = LocalTransactionState.ROLLBACK_MESSAGE;
        }
        return state;
    }

    /**
     * 回查走的方法
     *
     * @param messageExt
     * @return
     */
    @Override
    public LocalTransactionState checkLocalTransaction(MessageExt messageExt) {
        log.info("开始本地事务状态,{}", messageExt.getTransactionId());
        LocalTransactionState state;
        String transactionId = messageExt.getTransactionId();
        LambdaQueryWrapper<TransactionLog> querWapper = new LambdaQueryWrapper<>();
        querWapper.eq(TransactionLog::getTransactionId, transactionId);
        long count = transactionLogService.count(querWapper);
        if (count >= 1) {
            state = LocalTransactionState.COMMIT_MESSAGE;
        } else {
            state = LocalTransactionState.UNKNOW;
        }
        log.info("结束本地事务状态查询：{}", state);
        return state;
    }
}
