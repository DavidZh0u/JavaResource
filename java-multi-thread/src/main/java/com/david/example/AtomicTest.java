package com.david.example;

import java.util.concurrent.atomic.AtomicInteger;

public class AtomicTest {

    private AtomicInteger sum1 = new AtomicInteger(0);

    private Integer sum2 = 0;

    class Runnable_1 implements Runnable{
        @Override
        public void run() {
            for (int i = 0;i<10;i++){
                sum1.getAndIncrement();
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    class Runnable_2 implements Runnable{
        @Override
        public void run() {
            for (int i = 0;i<10;i++){
                sum2++;
                try{
                    Thread.sleep(100);
                }catch(InterruptedException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        AtomicTest test = new AtomicTest();
        Runnable_1 run1 = test.new Runnable_1();
        Runnable_2 run2 = test.new Runnable_2();
        for (int i = 0;i<10;i++){
            Thread thread = new Thread(run1);
            thread.start();
        }
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("AtomicInteger累加100次"+test.sum1.intValue());
        for (int i = 0;i<10;i++){
            Thread thread = new Thread(run2);
            thread.start();
        }
        try{
            Thread.sleep(1000);
        }catch(InterruptedException e){
            e.printStackTrace();
        }
        System.out.println("Integer累加100次"+test.sum2.intValue());

    }


}
