package com.david.example;

/**
 * @ClassName MyRunnable
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/5/29 17:10
 */
public class MyRunnable implements Runnable {

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName());
        System.out.println("起一个线程处理方法");
    }

    public static void main(String[] args) {

        MyRunnable myRunnable = new MyRunnable();
        System.out.println(Thread.currentThread().getName());
        Thread thread = new Thread(myRunnable);
        thread.start();

    }
}
