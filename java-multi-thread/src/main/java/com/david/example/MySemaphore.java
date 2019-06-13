package com.david.example;

import java.util.concurrent.Semaphore;

/**
 * @ClassName MySemaphore
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/6/10 16:00
 */
public class MySemaphore {

    static class Worker extends Thread{

        private int num;
        private Semaphore semaphore;

        public Worker(int num, Semaphore semaphore){
            this.num = num;
            this.semaphore = semaphore;
        }

        @Override
        public void run() {
            try {
                semaphore.acquire();
                System.out.println("工人"+this.num+"占用一台机器生产");
                Thread.sleep(2000);
                System.out.println("工人"+this.num+"释放一台机器资源");
                semaphore.release();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }

    public static void main(String[] args) {

        int N = 8;
        Semaphore semaphore = new Semaphore(5);
        for (int i = 0 ; i < N ; i ++){
            new Worker(i,semaphore).start();
        }

    }

}
