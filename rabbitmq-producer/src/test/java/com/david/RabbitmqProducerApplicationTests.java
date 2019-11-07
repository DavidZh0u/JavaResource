package com.david;

import com.david.mq.Sender;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

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

}
