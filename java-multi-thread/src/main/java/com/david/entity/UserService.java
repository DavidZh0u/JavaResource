package com.david.entity;

import java.time.LocalTime;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @ClassName UserService
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/5/30 17:32
 */
public class UserService {

    private ReentrantLock lock = new ReentrantLock();

    private Condition condition = lock.newCondition();

    private Semaphore semaphore = new Semaphore(2);


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

    public void method5(){
        System.out.println("加锁前："+Thread.currentThread().getName());
        try{
            Thread.sleep(5*1000);
            lock.lock();
            boolean hasWaitFlag = lock.hasQueuedThreads();
            if(hasWaitFlag){
                condition.signal();
            }
            System.out.println("加锁后："+Thread.currentThread().getName());
            condition.await();
            System.out.println("主动等待中："+Thread.currentThread().getName());
            for (int i=0;i<5;i++){
                System.out.println(Thread.currentThread().getName()+" : "+i);
            }
        }catch(InterruptedException e){
            e.printStackTrace();

        }finally {
            boolean hasWaitFlag = lock.hasQueuedThreads();
            if(hasWaitFlag){
                condition.signal();
            }
            lock.unlock();
        }
    }

    public void singleCall(){
        condition.signal();
    }

    public void method6(){
        try{
            System.out.println(Thread.currentThread().getName()+"将尝试竞争锁"+" -> "+ LocalTime.now());
            boolean hasLockFlag = lock.tryLock(3, TimeUnit.SECONDS);
            if(hasLockFlag){
                System.out.println("3秒内尝试获取了锁："+hasLockFlag+" - "+Thread.currentThread().getName()+" -> "+ LocalTime.now());
                Thread.sleep(10*1000);
            }else {
                System.out.println("3秒内尝试获取了锁："+hasLockFlag+" - "+Thread.currentThread().getName()+" -> "+ LocalTime.now());
            }
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            boolean hasLock = lock.isHeldByCurrentThread();
            if(hasLock){
                System.out.println("执行完毕，释放锁："+Thread.currentThread().getName()+" -> "+ LocalTime.now());
                lock.unlock();
            }else {
                System.out.println("没有获得锁，无需释放lock"+" -> "+ LocalTime.now());
            }
        }
    }

    public void method7(){
        try{
            semaphore.acquire();
            System.out.println("获取锁线程："+Thread.currentThread().getName()+" -> "+ LocalTime.now());
            Thread.sleep(5*1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }finally {
            //
            System.out.println("释放锁线程："+Thread.currentThread().getName()+" -> "+ LocalTime.now());
            semaphore.release();
        }
    }

}
