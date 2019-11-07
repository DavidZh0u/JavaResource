package com.david.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-07 17:57
 */
@Component
public class SubQueueReceiver {

    @Autowired
    private Queue consumerOneSubQueue;

    @RabbitListener(queues = "#{consumerOneSubQueue.name}" )
    public void receive(String msg) {
        String queueName = consumerOneSubQueue.getName();
        System.out.println("接受者 => "+queueName+" => "+msg);
    }

}
