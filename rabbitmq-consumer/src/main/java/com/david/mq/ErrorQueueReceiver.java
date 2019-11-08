package com.david.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-08 15:01
 */
@Component
public class ErrorQueueReceiver {

    @RabbitListener(queues = "errorLogQueue" )
    public void receive(String msg) {
        System.out.println("接受者 => errorLogQueue => "+msg);
    }

}
