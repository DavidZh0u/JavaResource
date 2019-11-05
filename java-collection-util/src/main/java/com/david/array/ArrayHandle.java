package com.david.array;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-03 22:09
 */
public class ArrayHandle {

    private static int max = 0;
    private static int min = 0;
    private static int sum = 0;
    private static double avg = 0;

    public static int[] getArray(int n){
        if(n<=0){
            System.out.println("请输入一个正整数！！！");
            return null;
        }
        int[] ints = new int[n];
        for (int i = 0; i < ints.length; i++) {
            int num = getNum();
            ints[i] = num;
            if(i==0){
                max = num;
                min = num;
            }
            if(num > max){
                max = num;
            }
            if(num < min){
                min = num;
            }
            sum += num;
        }
        Double dsum = Double.parseDouble(sum+"");
        Double dn = Double.parseDouble(n+"");
        avg = BigDecimal.valueOf(dsum).divide(BigDecimal.valueOf(dn),10, RoundingMode.HALF_UP).doubleValue();
        return ints;
    }

    public static int getNum(){
        //[0.0 - 1.0) * 90 +10 => [10,100)
        int num = (int)(Math.random() * 90 + 10);
        return num;
    }

    public static void main(String[] args) {
        int[] ints = getArray(13);
        for (int anInt : ints) {
            System.out.print(anInt+" ");
        }
        System.out.println();
        System.out.println("max = "+max);
        System.out.println("min = "+min);
        System.out.println("sum = "+sum);
        System.out.println("avg = "+avg);
    }

}
