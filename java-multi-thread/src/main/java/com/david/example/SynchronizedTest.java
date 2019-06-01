package com.david.example;

import com.david.entity.UserService;

/**
 * @ClassName SynchronizedTest
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/5/30 17:31
 */
public class SynchronizedTest {

    public UserService userService = new UserService();


    class RunnableOne implements Runnable{
        @Override
        public void run() {
            userService.methodOne();
        }
    }

    class RunnableTwo implements Runnable{
        @Override
        public void run() {
            userService.methodTwo();
        }
    }

    class RunnableThree implements Runnable{
        @Override
        public void run() {
            UserService.methodThree();
        }
    }

    class RunnableFour implements Runnable{
        @Override
        public void run() {
            UserService.methodFour();
        }
    }

    public static void main(String[] args) {
        SynchronizedTest test = new SynchronizedTest();
        RunnableOne one = test.new RunnableOne();
        RunnableTwo two = test.new RunnableTwo();
        RunnableThree three = test.new RunnableThree();
        RunnableFour four = test.new RunnableFour();
        Thread t1 = new Thread(one);
        Thread t2 = new Thread(two);
        Thread t3 = new Thread(three);
        Thread t4 = new Thread(four);
        t1.start();
        t2.start();
        t3.start();
        t4.start();


    }

}
