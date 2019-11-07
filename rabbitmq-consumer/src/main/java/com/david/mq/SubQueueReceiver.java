package com.david.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-07 17:57
 */
@Component
public class SubQueueReceiver {

    @RabbitListener(queues = "consumerSubQueue" )
    public void receive(String msg) {
        System.out.println("接受者 => consumerSubQueue => "+msg);
    }

}
