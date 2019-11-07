package com.david.config;

import org.springframework.amqp.core.*;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-05 22:47
 */
@Configuration
public class RabbitmqConfig {

    @Bean
    public Queue simpleQueue() {
        return new Queue("SimpleQueue");
    }

    @Bean
    public Queue workQueue() {
        return new Queue("WorkQueue");
    }

    @Bean
    public FanoutExchange psExchange(){
        return new FanoutExchange("psExchange");
    }
}
