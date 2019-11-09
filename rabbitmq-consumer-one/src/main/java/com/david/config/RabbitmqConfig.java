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
    public FanoutExchange psExchange(){
        return new FanoutExchange("psExchange");
    }

    @Bean
    public Queue consumerOneSubQueue(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding bindingAtPsExchange(Queue consumerOneSubQueue,FanoutExchange psExchange){
        return BindingBuilder.bind(consumerOneSubQueue).to(psExchange);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Queue allLogQueue(){
        return new AnonymousQueue();
    }

    @Bean
    public Binding bindingAtDirectExchange1(Queue allLogQueue,DirectExchange directExchange){
        return BindingBuilder.bind(allLogQueue).to(directExchange).with("info");
    }

    @Bean
    public Binding bindingAtDirectExchange2(Queue allLogQueue,DirectExchange directExchange){
        return BindingBuilder.bind(allLogQueue).to(directExchange).with("warning");
    }

    @Bean
    public Binding bindingAtDirectExchange3(Queue allLogQueue,DirectExchange directExchange){
        return BindingBuilder.bind(allLogQueue).to(directExchange).with("error");
    }

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
        return BindingBuilder.bind(orderQueue).to(topicExchange).with("*.淘宝.*");
    }

    @Bean
    public Binding bindingAtTopicExchange2(Queue orderQueue,TopicExchange topicExchange){
        return BindingBuilder.bind(orderQueue).to(topicExchange).with("*.京东.*");
    }

    @Bean
    public Binding bindingAtTopicExchange3(Queue orderQueue,TopicExchange topicExchange){
        return BindingBuilder.bind(orderQueue).to(topicExchange).with("*.拼多多.*");
    }

}
