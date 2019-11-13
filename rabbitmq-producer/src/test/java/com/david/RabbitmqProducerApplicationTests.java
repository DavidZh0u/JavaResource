package com.david;

import com.david.mq.SendService;
import com.david.mq.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.IOException;
import java.util.concurrent.TimeoutException;

@SpringBootTest
class RabbitmqProducerApplicationTests {

    @Test
    void contextLoads() {
    }

    @Autowired
    private Sender sender;

    @Test
    public void simpleQueueSendTest(){
        sender.send("Hello Simple Queue!");
    }

    @Test
    public void workQueueSendTest() throws InterruptedException{
        for (int i = 1; i <= 30; i++) {
            sender.sendToWorkQueue("msg - "+i);
            Thread.sleep(1000);
        }
    }

    @Test
    public void psExchangeSendTest() throws InterruptedException{
        for (int i = 0; i <10 ; i++) {
            sender.sendToPsExchange("msg - "+i);
            Thread.sleep(500);
        }
    }

    @Test
    public void directExchangeSendTest() throws InterruptedException{
        int i = 1;
        for (; i <= 5 ; i++) {
            sender.sendToDirectExchange("info","info - log - "+i);
            Thread.sleep(500);
        }
        for (; i <= 10 ; i++) {
            sender.sendToDirectExchange("warning","warning - log - "+i);
            Thread.sleep(500);
        }
        for (; i <= 15 ; i++) {
            sender.sendToDirectExchange("error","error - log - "+i);
            Thread.sleep(500);
        }
    }

    //自定义常量
    private static String[] citys = {"北京","上海","广州","深圳","杭州",
            "武汉","成都","重庆","天津","厦门"};
    private static String[] channels = {"淘宝","京东","拼多多","微信小程序",
            "快手","实体店"};
    private static String[] products = {"老年人补钙奶","成年人健身奶","青少年成长奶",
            "婴幼儿营养奶","菌多多乳酸菌饮料","酸多多酸奶","早餐奶","代餐奶减肥专供"};

    //获取[0，n)区间内的随机整数
    public static int getNum(int n){
        return (int)(Math.random() * n);
    }

    //获取一个随机的城市
    public static String getCity(){
        return citys[getNum(10)];
    }

   //获取一个随机渠道
    public static String getChannel(){
        return channels[getNum(6)];
    }

    //获取一个随机产品
    public static String getProduct(){
        return products[getNum(8)];
    }

    //获取一个随机路由键
    public static String getRoutingKey(){
        return getCity()+"."+getChannel()+"."+getProduct();
    }

    @Test
    public void topicExchangeSendTest() throws InterruptedException{
        for (int i = 0; i < 100 ; i++){
            Thread.sleep(100);
            String routingKey = getRoutingKey();
            //消息也放路由键，方便我们打印看效果。
            sender.sendToTopicExchange(routingKey,routingKey);
        }
    }

    //发送消息高可用测试之事务
    @Autowired
    private SendService sendService;

    //发送消息高可用测试之事务
    @Test
    public void testSendTx() throws IOException, TimeoutException {
        sendService.sendWithTransation("测试消息->事务回滚");
    }

    //发送消息高可用测试之同步确认
    @Test
    public void testSendSync() throws IOException, TimeoutException {
        boolean b = sendService.sendWithSyncConfirm("fanoutExchange","测试消息->同步确认");
        System.out.println(b);
    }

    //发送消息高可用测试之异步确认
    @Test
    public void testSendAsync(){
        sendService.sendWithAsyncConfirm("fanoutExchange","","测试消息->异步确认");
    }

    //发送消息高可用测试之异步确认
    @Test
    public void testSendAsyncWithDirectExchange(){
        sendService.sendWithAsyncConfirm("directExchange","test-routingkeyaaa","测试消息->异步确认");
    }

    //发送消息高可用测试之异步确认
    @Test
    public void testSendAsyncWithBackupExchange(){
        sendService.sendWithAsyncConfirm("businessExchange","businessKey","测试消息->异步确认222222222");
    }


}
