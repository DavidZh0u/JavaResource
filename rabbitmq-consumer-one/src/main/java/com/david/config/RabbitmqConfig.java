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

}
