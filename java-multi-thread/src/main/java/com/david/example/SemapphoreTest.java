package com.david.example;

import com.david.entity.UserService;

public class SemapphoreTest {

    private UserService userService;

    public SemapphoreTest(UserService userService){
        this.userService = userService;
    }

    class Runnable_1 implements Runnable{
        @Override
        public void run() {
            userService.method7();
        }
    }

    public static void main(String[] args) {
        UserService userService = new UserService();
        SemapphoreTest test = new SemapphoreTest(userService);
        Runnable runnable = test.new Runnable_1();
        Thread t1 = new Thread(runnable);
        Thread t2 = new Thread(runnable);
        Thread t3 = new Thread(runnable);
        Thread t4 = new Thread(runnable);
        Thread t5 = new Thread(runnable);
        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
    }

}
