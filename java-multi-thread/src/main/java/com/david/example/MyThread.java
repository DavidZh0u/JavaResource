package com.david.example;

/**
 * @ClassName MyThread
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/5/29 17:06
 */
public class MyThread extends Thread{

    @Override
    public void run(){
        System.out.println(Thread.currentThread().getName());
        System.out.println("MyThread.run()");
    }

    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getName());
        MyThread myThread = new MyThread();
        myThread.start();
    }

}
