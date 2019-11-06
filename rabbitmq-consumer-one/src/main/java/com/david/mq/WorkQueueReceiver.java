package com.david.mq;

import org.springframework.amqp.rabbit.annotation.RabbitHandler;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-06 18:00
 */
@Component
@RabbitListener(queues = "WorkQueue" )
public class WorkQueueReceiver {

    @RabbitHandler
    public void receive(String msg) throws InterruptedException{
        Thread.sleep(1000);
        System.out.println("接受者 => WorkQueue => "+msg);
    }

}
