package com.david.example;

/**
 * @ClassName MyVolatile
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/6/10 16:31
 */
public class MyVolatile {

    private volatile Integer key = 0;

    public Thread threadFactory(int num){
        return new Thread(){
            @Override
            public void run() {
                System.out.println("第"+num+"次计算，结果:"+math());
            }
        };
    }

    public int math(){
        key = key+1;
        return key;
    }

    public static void main(String[] args) {
        MyVolatile mv = new MyVolatile();
        for (int i = 0;i<20;i++){
            mv.threadFactory(i).start();
        }
    }

}
