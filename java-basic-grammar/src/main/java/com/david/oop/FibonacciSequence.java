package com.david.oop;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-06 16:38
 */
public class FibonacciSequence {

    public static long recursionMethod(int n){
        if(n<0){
            return 0;
        }else if(n==1 || n==2){
            return 1;
        }else {
            return recursionMethod(n-1)+recursionMethod(n-2);
        }
    }

    public static long circleMethod(int n){
        long f1 = 1;
        long f2 = 0;
        long sum = 0;

        if (n <= 0) {
            sum = 0;
        }else if(n == 1 || n == 2){
            sum = 1;
        }else {
            for (int i = 2; i <= n ; i++) {
                sum = f1 + f2;
                f2 = f1;
                f1 = sum;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        int n = 10;
        long start1 = System.currentTimeMillis();
        System.out.println(recursionMethod(10));
        System.out.println("递归耗时："+(System.currentTimeMillis() - start1));
        long start2 = System.currentTimeMillis();
        System.out.println(circleMethod(n));
        System.out.println("循环耗时："+(System.currentTimeMillis() - start2));
    }

}
