package com.david.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;

/**
 * @ClassName MyCallable
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/5/29 17:16
 */
public class MyCallable implements Callable {

    public Integer i;

    public MyCallable(int k){
        i = k;
    }

    @Override
    public Object call() throws Exception {
        System.out.println(Thread.currentThread().getName());
        return "号码："+i;
    }

    public static void main(String[] args) throws InterruptedException,ExecutionException{
        ExecutorService pool = Executors.newFixedThreadPool(5);
        List<Future> list = new ArrayList<>();
        for (int i=0;i<10;i++){
            Callable c = new MyCallable(i);
            Future f = pool.submit(c);
            list.add(f);
        }
        pool.shutdown();
        for (Future future : list) {
            System.out.println("res : "+future.get().toString());
        }

    }

}
