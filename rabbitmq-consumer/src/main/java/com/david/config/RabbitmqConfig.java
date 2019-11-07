package com.david.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
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

}
