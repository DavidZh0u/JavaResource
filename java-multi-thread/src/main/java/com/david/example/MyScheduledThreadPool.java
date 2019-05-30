package com.david.example;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * @ClassName MyScheduledThreadPool
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/5/29 18:14
 */
public class MyScheduledThreadPool {

    public static void main(String[] args) {
        ScheduledExecutorService scheduledThreadPool = Executors.newScheduledThreadPool(3);
        scheduledThreadPool.schedule(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" : 延迟三秒");
            }
        },3, TimeUnit.SECONDS);
        scheduledThreadPool.scheduleAtFixedRate(new Runnable() {
            @Override
            public void run() {
                System.out.println(Thread.currentThread().getName()+" : 延迟1秒后每三秒执行一次");
            }
        },1,3,TimeUnit.SECONDS);
    }

}
