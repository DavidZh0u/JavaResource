package com.david.proxy;

import com.david.service.UserService;

import java.lang.reflect.InvocationHandler;
import java.lang.reflect.Method;
import java.lang.reflect.Proxy;

public class JdkProxyUtil {

    public static Object getProxy(UserService service){
        Object obj = Proxy.newProxyInstance(service.getClass().getClassLoader(),
                service.getClass().getInterfaces(),
                new InvocationHandler() {
                    @Override
                    public Object invoke(Object proxy, Method method, Object[] args) throws Throwable {

                        System.out.println("前置-记录日志");
                        Object object =  method.invoke(service,args);
                        System.out.println("后置-记录日志");

                        return object;
                    }
                });

        return obj;
    }

}
