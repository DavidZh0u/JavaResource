package com.david.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.HashMap;
import java.util.Map;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-12 13:03
 */
@Configuration
public class HighRabbitmqConfig {

    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("fanoutExchange");
    }

    @Bean
    public Queue myTestQueue(){
        return new Queue("myTestQueue");
    }

    @Bean
    public Binding testQueueBingding(Queue myTestQueue, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(myTestQueue).to(fanoutExchange);
    }

    @Bean
    public Queue myTestQueue2(){
        return new Queue("myTestQueue2");
    }

    @Bean
    public Binding testQueueBingding2(Queue myTestQueue2, DirectExchange directExchange){
        return BindingBuilder.bind(myTestQueue2).to(directExchange).with("test-routingkey");
    }

    //处理业务的交换机
    private final static String EXCHANGE_BUSINESS_NAME = "businessExchange";
    //备份交换机
    private final static String EXCHANGE_BACKUP_NAME = "backupExchange";
    //重试交换机（死信）
    private final static String EXCHANGE_RETRY_NAME = "retryExchange";
    //消费失败交换机
    private final static String EXCHANGE_FAIL_NAME = "failExchange";

    //处理业务的队列
    private final static String QUEUE_BUSINESS_NAME = "businessQueue";
    //告警队列
    private final static String QUEUE_WARNING_NAME = "warningQueue";
    //重试队列（死信）
    private final static String QUEUE_RETRY_NAME = "retryQueue";
    //消费失败队列
    private final static String QUEUE_FAIL_NAME = "failQueue";

    //处理业务的路由key
    private final static String ROUTINGKEY_BUSINESS_NAME = "businessKey";
    //处理重试的路由key
    private final static String ROUTINGKEY_RETRY_NAME = "retryKey";

    @Bean
    public FanoutExchange backupExchange(){
        return new FanoutExchange(EXCHANGE_BACKUP_NAME);
    }

    @Bean
    public DirectExchange businessExchange(){
        Map<String, Object> arguments = new HashMap<>();
        //该交换机的备份交换机
        arguments.put("alternate-exchange",EXCHANGE_BACKUP_NAME);
        return new DirectExchange(EXCHANGE_BUSINESS_NAME,true,false,arguments);
    }

    @Bean
    public Queue businessQueue(){
        Map<String, Object> args = new HashMap<>();
        //x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", EXCHANGE_RETRY_NAME);
        //x-dead-letter-routing-key  这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", ROUTINGKEY_RETRY_NAME);
        return new Queue(QUEUE_BUSINESS_NAME,true,false,false,args);
    }

    @Bean
    public Queue warningQueue(){
        return new Queue(QUEUE_WARNING_NAME);
    }

    @Bean
    public Binding businessBinding(DirectExchange businessExchange,Queue businessQueue){
        return BindingBuilder.bind(businessQueue).to(businessExchange).with(ROUTINGKEY_BUSINESS_NAME);
    }

    @Bean
    public Binding backupBinding(FanoutExchange backupExchange,Queue warningQueue){
        return BindingBuilder.bind(warningQueue).to(backupExchange);
    }

    @Bean
    public DirectExchange retryExchange(){
        return new DirectExchange(EXCHANGE_RETRY_NAME);
    }

    @Bean
    public FanoutExchange failExchange(){
        return new FanoutExchange(EXCHANGE_FAIL_NAME);
    }

    @Bean
    public Queue retryQueue(){
        Map<String, Object> args = new HashMap<>();
        //x-dead-letter-exchange    这里声明当前队列绑定的死信交换机
        args.put("x-dead-letter-exchange", EXCHANGE_BUSINESS_NAME);
        //x-dead-letter-routing-key  这里声明当前队列的死信路由key
        args.put("x-dead-letter-routing-key", ROUTINGKEY_BUSINESS_NAME);
        //x-message-ttl 声明队列的ttl
        args.put("x-message-ttl",10000);
        return new Queue(QUEUE_RETRY_NAME,true,false,false,args);
    }

    @Bean
    public Queue failQueue(){
        return new Queue(QUEUE_FAIL_NAME);
    }

    @Bean
    public Binding retryBinding(Queue retryQueue,DirectExchange retryExchange){
        return BindingBuilder.bind(retryQueue).to(retryExchange).with(ROUTINGKEY_RETRY_NAME);
    }

    @Bean
    public Binding failBinding(Queue failQueue,FanoutExchange failExchange){
        return BindingBuilder.bind(failQueue).to(failExchange);
    }

}
