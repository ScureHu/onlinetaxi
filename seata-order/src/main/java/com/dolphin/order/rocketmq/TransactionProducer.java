package com.dolphin.order.rocketmq;

import com.dolphin.order.service.ITbOrderService;
import org.apache.rocketmq.client.exception.MQClientException;
import org.apache.rocketmq.client.producer.TransactionMQProducer;
import org.apache.rocketmq.client.producer.TransactionSendResult;
import org.apache.rocketmq.common.message.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

@Component
public class TransactionProducer {
    private String producerGroup = "order_trans_group";
    //事务消息
    private TransactionMQProducer producer;
    @Autowired
    private OrderTransactionListener orderTransactionListener;
    //执行任务的线程组
    ThreadPoolExecutor executor =
            new ThreadPoolExecutor(5, 5, 5000, TimeUnit.SECONDS, new ArrayBlockingQueue<>(50));
    @Value("${rocketmq.name-server}")
    private String nameAddress;

    @PostConstruct
    public void init() {
        producer = new TransactionMQProducer(producerGroup);
        producer.setNamesrvAddr(nameAddress);
        producer.setSendMsgTimeout(Integer.MAX_VALUE);
        producer.setTransactionListener(orderTransactionListener);
        producer.setExecutorService(executor);
        this.start();
    }

    private void start() {
        try {
            this.producer.start();
        } catch (MQClientException e) {
            e.printStackTrace();
        }
    }

    public TransactionSendResult send(String data, String topic) throws MQClientException {
        Message message = new Message(topic, data.getBytes());
        return this.producer.sendMessageInTransaction(message, null);
    }
}
