package com.david;

import com.david.cglib.CgLibProxyUtil;
import com.david.proxy.JdkProxyUtil;
import com.david.service.UserService;
import com.david.service.impl.UserServiceImpl;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest
public class SpringResourceModuleApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testJdkProxy(){
        UserService service = new UserServiceImpl();

        UserService serviceProxy = (UserService) JdkProxyUtil.getProxy(service);

        service.getUser();
        System.out.println("=======================================================");
        serviceProxy.getUser();

    }

    @Test
    public void testCgLibProxy(){
        UserService service = new UserServiceImpl();

        UserService serviceProxy = (UserService) CgLibProxyUtil.getProxyClass(service);

        service.getUser();
        System.out.println("=======================================================");
        serviceProxy.getUser();

    }
}
