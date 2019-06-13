package com.david.example;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;

/**
 * @ClassName MyCyclicBarrier
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/6/10 14:31
 */
public class MyCyclicBarrier {

    static class Writer extends Thread{
        private CyclicBarrier cyclicBarrier;
        public Writer(CyclicBarrier cyclicBarrier){
            this.cyclicBarrier = cyclicBarrier;
        }

        @Override
        public void run() {
            try {
                System.out.println("线程 "+Thread.currentThread().getName()+"开始运行");
                Thread.sleep(5000);
                System.out.println("线程 "+Thread.currentThread().getName()+"写入数据完毕，等待其他线程写入完毕");
                cyclicBarrier.await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }catch (BrokenBarrierException es){
                es.printStackTrace();
            }
            System.out.println("所有线程写入完毕，继续处理其他任务，比如数据操作");
        }
    }

    public static void main(String[] args) throws InterruptedException{
        int N = 4;
        CyclicBarrier barrier = new CyclicBarrier(N);
        for (int i = 0 ; i< 4 ;i++){
            Thread.sleep(1000);
            new Writer(barrier).start();
        }
    }

}
