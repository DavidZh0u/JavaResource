package com.david.example;

import com.david.entity.UserService;

public class ReentrantLockTest{

    private UserService userService;

    public ReentrantLockTest(UserService userService){
        this.userService = userService;
    }

    class Runnable1 implements Runnable{
        @Override
        public void run() {
            userService.method5();
        }
    }

    class Runnable2 implements Runnable{
        @Override
        public void run() {
            userService.method6();
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        ReentrantLockTest test = new ReentrantLockTest(userService);
//        Runnable1 runnable1 = test.new Runnable1();
//        Thread thread1 = new Thread(runnable1);
//        Thread thread2 = new Thread(runnable1);
//        Thread thread3 = new Thread(runnable1);
//        thread1.start();
//        thread2.start();
//        thread3.start();

        Runnable2 runnable2 = test.new Runnable2();
        Thread t1 = new Thread(runnable2);
        Thread t2 = new Thread(runnable2);
        Thread t3 = new Thread(runnable2);
        t1.start();
        t2.start();
        t3.start();


    }

}
