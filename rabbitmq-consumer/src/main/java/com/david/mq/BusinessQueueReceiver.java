package com.david.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.core.MessageProperties;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-12 14:41
 */
@Component
public class BusinessQueueReceiver {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @RabbitListener(queues = "businessQueue" )
    public void receive(Message message, Channel channel) throws IOException {
        String msg = new String(message.getBody());
        long retryCount = getRetryCount(message.getMessageProperties());
        if(retryCount > 3){
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            rabbitTemplate.convertAndSend("failExchange","",msg);
            return;
        }
        System.out.println("接受者 => businessQueue => "+msg);
        boolean ack = true;

        try {
            //执行业务逻辑
            int num = 5 / 0;

        }catch (Exception e){
            ack = false;
        }
        if(ack){
            channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
            System.out.println("消息消费正常！！！");
        }else {
            channel.basicNack(message.getMessageProperties().getDeliveryTag(),false,false);
            System.out.println("消息消费出现异常......");
        }
    }

    @RabbitListener(queues = "failQueue" )
    public void receiveRetry(Message message, Channel channel) throws IOException {
        System.out.println("消息的终结 => failQueue => "+new String(message.getBody()));
        channel.basicAck(message.getMessageProperties().getDeliveryTag(),false);
    }

    /**
     * 获取消息被重试的次数
     */
    public long getRetryCount(MessageProperties messageProperties) {
        Long retryCount = 0L;
        if (null != messageProperties) {
            List<Map<String, ?>> deaths = messageProperties.getXDeathHeader();
            if(deaths != null && deaths.size()>0){
                Map<String, Object> death = (Map<String, Object>)deaths.get(0);
                retryCount = (Long) death.get("count");
            }

        }
        return retryCount;
    }

}
