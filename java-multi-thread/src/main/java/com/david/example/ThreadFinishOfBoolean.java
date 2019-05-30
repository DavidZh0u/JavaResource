package com.david.example;

/**
 * @ClassName ThreadFinishOne
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/5/30 11:05
 */
public class ThreadFinishOfBoolean implements Runnable{

    public volatile boolean exit = false;

    public volatile Integer flag = 1;

    @Override
    public void run() {
        while (!exit){
            flag++;
            System.out.println(Thread.currentThread().getName()+" : "+flag);
            if(flag==100){
                exit = true;
                System.out.println(Thread.currentThread().getName() +" will get out : "+exit);
            }
        }
    }

    public static void main(String[] args) {
        ThreadFinishOfBoolean one = new ThreadFinishOfBoolean();
        Thread t = new Thread(one);
        t.start();
    }
}
