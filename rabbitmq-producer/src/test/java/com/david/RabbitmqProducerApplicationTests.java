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
        sender.send("Hello Simple Queue!111111111");
    }

    @Test
    public void workQueueSendTest() throws InterruptedException{
        for (int i = 1; i <= 30; i++) {
            sender.sendToWorkQueue("msg - "+i);
            Thread.sleep(1000);
        }
    }

}
