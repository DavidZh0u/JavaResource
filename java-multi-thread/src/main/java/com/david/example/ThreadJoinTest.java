package com.david.example;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * @ClassName ThreadJoinTest
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/6/3 9:43
 */
public class ThreadJoinTest {

    private AtomicInteger ai = new AtomicInteger(0);

    class RunnableMain implements Runnable{

        private Thread[] threads;

        public RunnableMain(Thread[] threads){
            this.threads = threads;
        }

        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName()+"开始处理，AI开始值为："+ai.intValue());
            try {
                int k =  1;
                for (Thread thread : threads) {
                    thread.setName("son thread - "+k++);
                    thread.start();
                    thread.join();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }

            /*int k =  1;
            for (Thread thread : threads) {
                thread.setName("son thread - "+k++);
                thread.start();
            }*/

            System.out.println(Thread.currentThread().getName()+"开始处理，AI最终值为："+ai.intValue());
        }
    }

    class Runnable_1 implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ai.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + " -> "+ai.intValue());
        }
    }

    class Runnable_2 implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ai.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + " -> "+ai.intValue());
        }
    }

    class Runnable_3 implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ai.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + " -> "+ai.intValue());
        }
    }

    class Runnable_4 implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ai.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + " -> "+ai.intValue());
        }
    }

    class Runnable_5 implements Runnable{
        @Override
        public void run() {
            try {
                Thread.sleep(1000*2);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            ai.getAndIncrement();
            System.out.println(Thread.currentThread().getName() + " -> "+ai.intValue());
        }
    }

    public static void main(String[] args) {
        ThreadJoinTest test = new ThreadJoinTest();
        Runnable_1 r1 = test.new Runnable_1();
        Runnable_2 r2 = test.new Runnable_2();
        Runnable_3 r3 = test.new Runnable_3();
        Runnable_4 r4 = test.new Runnable_4();
        Runnable_5 r5 = test.new Runnable_5();
        Thread t1 = new Thread(r1);
        Thread t2 = new Thread(r2);
        Thread t3 = new Thread(r3);
        Thread t4 = new Thread(r4);
        Thread t5 = new Thread(r5);
        Thread[] ts = new Thread[5];
        ts[0] = t1;
        ts[1] = t2;
        ts[2] = t3;
        ts[3] = t4;
        ts[4] = t5;
        RunnableMain main = test.new RunnableMain(ts);
        Thread mainThread = new Thread(main);
        mainThread.setName("main thread ");
        mainThread.start();

        /*System.out.println("AI开始值为："+test.ai.intValue());
        try {
            for (Thread thread : ts) {
                thread.setName("son thread - "+test.ai.intValue());
                thread.join();
                thread.start();
            }
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("AI开始值为："+test.ai.intValue());*/
    }

}
