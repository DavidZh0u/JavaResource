package com.david.mq;

import org.springframework.amqp.core.Queue;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-08 15:17
 */
@Component
public class AllLogQueueReceiver {

    @Autowired
    private Queue allLogQueue;

    @RabbitListener(queues = "#{allLogQueue.name}" )
    public void receive(String msg) {
        String queueName = allLogQueue.getName();
        System.out.println("接受者 => "+queueName+" => "+msg);
    }

}
