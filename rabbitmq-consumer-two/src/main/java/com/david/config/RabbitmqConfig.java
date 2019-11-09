package com.david.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-07 17:49
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public TopicExchange topicExchange(){
        return new TopicExchange("topicExchange");
    }

    @Bean
    public Queue orderQueue(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding bindingAtTopicExchange1(Queue orderQueue,TopicExchange topicExchange){
        return BindingBuilder.bind(orderQueue).to(topicExchange).with("上海.*.早餐奶");
    }

}
