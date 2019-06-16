package com.david.example;

import java.util.concurrent.ArrayBlockingQueue;
import java.util.concurrent.BlockingQueue;

public class MyBlockQueue {

    private BlockingQueue bQueue;

    static class MyEntity{
        private String name;



    }


    static class TaskInter implements Runnable{
        @Override
        public void run() {

        }
    }

    static class TaskOuter implements Runnable{
        @Override
        public void run() {

        }
    }

    public static void main(String[] args) throws InterruptedException{
        boolean flag = false;
        BlockingQueue bq = new ArrayBlockingQueue(2);
        bq.put(null);

    }

}
