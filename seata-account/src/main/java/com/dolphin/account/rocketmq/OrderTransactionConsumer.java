package com.dolphin.account.rocketmq;

import com.alibaba.fastjson.JSON;
import com.dolphin.account.entity.TbAccount;
import com.dolphin.account.service.ITbAccountService;
import lombok.extern.slf4j.Slf4j;
import org.apache.rocketmq.client.consumer.DefaultMQPushConsumer;
import org.apache.rocketmq.client.consumer.listener.*;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.common.message.MessageExt;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.List;

@Component
@Slf4j
public class OrderTransactionConsumer {
    private String consumerGroup = "account-group";
    private DefaultMQPushConsumer consumer;

    @Value("${rocketmq.name-server}")
    private String nameAddress;

    @Autowired
    private ITbAccountService accountService;

    @PostConstruct
    public void init() throws MQClientException {
        consumer = new DefaultMQPushConsumer(consumerGroup);
        consumer.setNamesrvAddr(nameAddress);
        consumer.subscribe("order", "*");
        consumer.registerMessageListener(new MessageListenerConcurrently() {
            @Override
            public ConsumeConcurrentlyStatus consumeMessage(List<MessageExt> list, ConsumeConcurrentlyContext consumeConcurrentlyContext) {
                log.info("消费者线程监听到信息:");
                try {
                    for (MessageExt messageExt : list) {
                        log.info("开始处理订单数据,准备扣钱....");
                        String data = new String(messageExt.getBody());
                        TbAccount tbAccount = JSON.parseObject(data, TbAccount.class);
                        accountService.deduct(tbAccount.getUserId(), tbAccount.getMoney());
                    }
                    return ConsumeConcurrentlyStatus.CONSUME_SUCCESS;
                } catch (Exception e) {
                    log.error("处理消费者数据发生异常.{}", e);
                    return ConsumeConcurrentlyStatus.RECONSUME_LATER;
                }
            }
        });
        //2次失败，就进入死信队列 这里增加死信队列消费消息
        consumer.setMaxReconsumeTimes(2);
        consumer.start();
    }
}
