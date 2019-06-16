package com.david.example;

import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

public class MyThreadPoolExecutor {

    private int corePoolSize = 2;
    private int maximumPoolSize = 3;
    private long keepAliveTime = 10;
    private TimeUnit unit = TimeUnit.SECONDS;
    BlockingQueue<Runnable> workQueue = new ArrayBlockingQueue<>(10);
    ThreadFactory threadFactory = new MyThreadFactory();
    RejectedExecutionHandler handler = new MyRejectHandler();

    static class MyThreadFactory implements ThreadFactory{

        private final AtomicInteger threadNum = new AtomicInteger(1);

        @Override
        public Thread newThread(Runnable r) {
            Thread t = new Thread(r,"my-thread-"+threadNum.getAndIncrement());
            System.out.println(t.getName()+" has been created ");
            return t;
        }
    }

    public static class MyRejectHandler implements RejectedExecutionHandler{
        @Override
        public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
            doSomeThing(r,executor);
        }

        private void doSomeThing(Runnable r,ThreadPoolExecutor e){
            System.out.println(r.toString()+" was rejected ");
        }
    }

    static class MyTask implements Runnable{
        private String name;

        public MyTask(String name){
            this.name = name;
        }

        @Override
        public void run() {
            try{
                System.out.println(this.toString()+" is running  ");
                Thread.sleep(3000);
            }catch(InterruptedException e){
                e.printStackTrace();
            }
        }

        public String getName(){
            return name;
        }

        @Override
        public String toString(){
            return "MyTask [name="+name+"]";
        }
    }

    public static void main(String[] args) throws InterruptedException{
        MyThreadPoolExecutor test = new MyThreadPoolExecutor();
        ThreadPoolExecutor executor = new ThreadPoolExecutor(test.corePoolSize,
                test.maximumPoolSize,test.keepAliveTime,test.unit,
                test.workQueue,test.threadFactory,test.handler);
        for (int i = 1;i <= 50;i++){
            MyTask task = new MyTask(i+"");
            Thread.sleep(500);
            executor.execute(task);
        }
    }


}
