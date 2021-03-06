package com.david.mq;


import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.TopicExchange;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-05 18:16
 */
@Component
public class Sender {

    @Autowired
    private RabbitTemplate template;

    @Autowired
    private Queue simpleQueue;

    @Autowired
    private Queue workQueue;

    @Autowired
    private FanoutExchange psExchange;

    @Autowired
    private DirectExchange directExchange;

    @Autowired
    private TopicExchange topicExchange;

    public void send(String message) {
        this.template.convertAndSend(simpleQueue.getName(), message);
        System.out.println("发送者 => "+simpleQueue.getName()+" => "+message);
    }

    public void sendToWorkQueue(String msg){
        this.template.convertAndSend(workQueue.getName(), msg);
        System.out.println("发送者 => "+workQueue.getName()+" => "+msg);
    }

    public void sendToPsExchange(String msg){
        this.template.convertAndSend(psExchange.getName(),"",msg);
        System.out.println("发送者 => "+psExchange.getName()+" => "+msg);
    }

    public void sendToDirectExchange(String routingKey,String msg){
        this.template.convertAndSend(directExchange.getName(),routingKey,msg);
        System.out.println("发送者 => "+directExchange.getName()+" => "+routingKey+" => "+msg);
    }

    public void sendToTopicExchange(String routingKey,String msg){
        this.template.convertAndSend(topicExchange.getName(),routingKey,msg);
        System.out.println("发送者 => "+topicExchange.getName()+" => "+routingKey+" => "+msg);
    }

}
