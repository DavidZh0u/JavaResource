package com.david.cglib;

import com.david.service.UserService;
import org.springframework.cglib.proxy.Enhancer;
import org.springframework.cglib.proxy.MethodInterceptor;
import org.springframework.cglib.proxy.MethodProxy;

import java.lang.reflect.Method;

public class CgLibProxyUtil {

    public static Object getProxy(UserService service){

        //创建增强类
        Enhancer enhancer = new Enhancer();

        //设置需要增强的类的类对象
        enhancer.setSuperclass(service.getClass());

        //设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                long a = System.currentTimeMillis();
                System.out.println("前置记录："+a);
                Object obj = methodProxy.invokeSuper(object,args);
                long b = System.currentTimeMillis();
                System.out.println("后置记录："+b);
                System.out.println("程序运行总时长 : "+(b-a));
                return obj;
            }
        });

        return enhancer.create();
    }

    public static Object getProxyClass(Object obj){

        //创建增强类
        Enhancer enhancer = new Enhancer();

        //设置需要增强的类的类对象
        enhancer.setSuperclass(obj.getClass());

        //设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                long a = System.currentTimeMillis();
                System.out.println("前置记录："+a);
                Object objCmd = methodProxy.invokeSuper(object,args);
                long b = System.currentTimeMillis();
                System.out.println("后置记录："+b);
                System.out.println("程序运行总时长 : "+(b-a));
                return objCmd;
            }
        });

        return enhancer.create();
    }

    public static Object getProxyClassByLambda(Object obj){

        //创建增强类
        Enhancer enhancer = new Enhancer();

        //设置需要增强的类的类对象
        enhancer.setSuperclass(obj.getClass());

        //设置回调函数
        enhancer.setCallback(new MethodInterceptor() {
            @Override
            public Object intercept(Object object, Method method, Object[] args, MethodProxy methodProxy) throws Throwable {
                long a = System.currentTimeMillis();
                System.out.println("前置记录："+a);
                Object objCmd = methodProxy.invokeSuper(object,args);
                long b = System.currentTimeMillis();
                System.out.println("后置记录："+b);
                System.out.println("程序运行总时长 : "+(b-a));
                return objCmd;
            }
        });

        return enhancer.create();
    }

}
