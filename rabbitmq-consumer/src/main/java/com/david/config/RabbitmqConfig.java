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
    public Queue consumerSubQueue(){
        return new Queue("consumerSubQueue");
    }

    @Bean
    public Binding bindingAtPsExchange(Queue consumerSubQueue,FanoutExchange psExchange){
        return BindingBuilder.bind(consumerSubQueue).to(psExchange);
    }

    @Bean
    public DirectExchange directExchange(){
        return new DirectExchange("directExchange");
    }

    @Bean
    public Queue errorLogQueue(){
        return new Queue("errorLogQueue");
    }

    @Bean
    public Binding bindingAtDirectExchange(Queue errorLogQueue,DirectExchange directExchange){
        return BindingBuilder.bind(errorLogQueue).to(directExchange).with("error");
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
    public Binding bindingAtTopicExchange(Queue orderQueue,TopicExchange topicExchange){
        return BindingBuilder.bind(orderQueue).to(topicExchange).with("武汉.#");
    }

}
