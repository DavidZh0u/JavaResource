package com.david.entity;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/5/30 17:32
 */
public class UserService {

    public synchronized void methodOne(){
        System.out.println("获取实例锁，执行方法一");
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public synchronized void methodTwo(){
        System.out.println("获取实例锁，执行方法二");
    }

    public static synchronized void methodThree(){
        System.out.println("获取类对象锁，执行方法三");
        try {
            Thread.sleep(5*1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

    }

    public static synchronized void methodFour(){
        System.out.println("获取类对象锁，执行方法四");
    }

}
