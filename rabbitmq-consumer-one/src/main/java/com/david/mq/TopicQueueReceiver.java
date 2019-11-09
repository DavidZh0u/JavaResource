package com.david.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-09 14:44
 */
@Component
public class TopicQueueReceiver {

    @Autowired
    private Queue orderQueue;

    @RabbitListener(queues = "#{orderQueue.name}" )
    public void receive(String msg) {
        String queueName = orderQueue.getName();
        System.out.println("接受者 => "+queueName+" => "+msg);
    }

}
