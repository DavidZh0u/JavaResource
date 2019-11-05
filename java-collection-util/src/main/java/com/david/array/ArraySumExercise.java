package com.david.array;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-03 17:03
 */
public class ArraySumExercise {

    public static int getSum(){
        int sum = 0;
        int[][] ints = new int[][]{{2,5,8},{12,9},{7,0,6,4}};
        for (int[] anInt : ints) {
            for (int i : anInt) {
                sum += i;
            }
        }
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(getSum());
    }
}
