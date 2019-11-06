package com.david.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-05 18:27
 */
@Component
@RabbitListener(queues = "SimpleQueue" )
public class SimpleQueueReceiver {

    @RabbitHandler
    public void receive(String msg) {
        System.out.println("接受者 => SimpleQueue => "+msg);
    }

}
