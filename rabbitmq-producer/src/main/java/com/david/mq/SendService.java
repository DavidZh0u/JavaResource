package com.david.mq;

import com.rabbitmq.client.Channel;
import org.springframework.amqp.core.DirectExchange;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.connection.Connection;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.connection.CorrelationData;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.io.IOException;
import java.util.UUID;
import java.util.concurrent.TimeoutException;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-10 13:59
 */
@Component
public class SendService {

    @Autowired
    private RabbitTemplate rabbitTemplate;

    @Autowired
    private FanoutExchange fanoutExchange;

    @Autowired
    private DirectExchange businessExchange;

    @Autowired
    private FanoutExchange backupExchange;


    /**
     * 1.获取链接工厂
     * 2.开启连接
     * 3.建立信道(true)
     * 4.开启事务（本方法中已经在建立信道时开启了事务）
     * */
    public boolean sendWithTransation(String msg) throws IOException,TimeoutException{
        //获取连接工厂
        ConnectionFactory connectionFactory = rabbitTemplate.getConnectionFactory();

        //开启连接 - tcp连接
        Connection connection = connectionFactory.createConnection();

        // 建立信道 构造参数 true代表该信道开启 Transactional 事务模式
        // true - createChannel()方法内部已经调用了channel.txSelect()
        Channel channel = connection.createChannel(true);

        try {
            channel.basicPublish(fanoutExchange.getName(),"",true,
                    com.rabbitmq.client.MessageProperties.PERSISTENT_BASIC,msg.getBytes());
//            int num = 5 / 0;
            channel.txCommit();
            return true;
        }catch (Exception e){
            channel.txRollback();
            e.printStackTrace();
        }finally {
            channel.close();
            connection.close();
        }
        return false;
    }

    /**
     * 1.获取链接工厂
     * 2.开启连接
     * 3.建立信道(false)
     * 4.开启发布确认模式
     **/
    public boolean sendWithSyncConfirm(String exchangeName,String msg) throws IOException,TimeoutException{
        //获取连接工厂
        ConnectionFactory connectionFactory = rabbitTemplate.getConnectionFactory();

        //开启连接 - tcp连接
        Connection connection = connectionFactory.createConnection();

        // 建立信道
        // false - 不开启事务
        Channel channel = connection.createChannel(false);

        try {
            //开启发布确认模式
            channel.confirmSelect();
            channel.basicPublish(exchangeName,"",true,
                    com.rabbitmq.client.MessageProperties.PERSISTENT_BASIC,msg.getBytes());
            return channel.waitForConfirms();
        }catch (Exception e){
//            e.printStackTrace();
        }finally {
            channel.close();
            connection.close();
        }
        return false;
    }

    public void sendWithAsyncConfirm(String exchangeName, String routingKeyParam,String msg) {

        //获取回调
        rabbitTemplate.setReturnCallback((Message message, int replyCode, String replyText, String exchange, String routingKey) -> {
            String correlationId = message.getMessageProperties().getHeaders().get("spring_returned_message_correlation").toString();
            String oriMsg = new String(message.getBody());
            System.out.println("消息ID: "+correlationId+"\n"
                    +"消息: "+message+"\n"
                    +"应答码: "+replyCode+"\n"
                    +"原因: "+replyText+"\n"
                    +"交换机: "+exchange+"\n"
                    +"路由键: "+routingKey+"\n"
                    +"原消息: "+oriMsg+"\n");
        });

        // 获取异步确认
        rabbitTemplate.setConfirmCallback((CorrelationData correlationData, boolean ack, String cause) -> {
            if (ack) {
                System.out.println("消息id为: " + correlationData + "的消息，已经被ack成功");
            } else {
                System.out.println("消息id为: " + correlationData + "的消息，消息nack，失败原因是：" + cause);
            }
        });

        //发送消息
        rabbitTemplate.convertAndSend(exchangeName,routingKeyParam,msg,
                new CorrelationData(UUID.randomUUID().toString().replace("-","")));
    }



}
