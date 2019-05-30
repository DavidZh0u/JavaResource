package com.david.example;

/**
 * @ClassName ThreadFinishOfInterrupt
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/5/30 13:53
 */
public class ThreadFinishOfInterrupt implements Runnable{

    public synchronized boolean isInterrupted(){
        Thread thread = Thread.currentThread();
        return thread.isInterrupted();
    }

    @Override
    public void run() {
        int i = 1;
        while (!isInterrupted()){
            System.out.println("第"+i+"次");

            try {
                Thread.sleep(5*1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
                break;
            }
            i++;
        }
    }

    public static void main(String[] args) {
        ThreadFinishOfInterrupt interrupt = new ThreadFinishOfInterrupt();
        Thread t = new Thread(interrupt);
        t.start();
    }

}
