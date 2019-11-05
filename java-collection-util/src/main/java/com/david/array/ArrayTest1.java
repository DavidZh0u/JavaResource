package com.david.array;

import java.util.Scanner;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-02 17:36
 */
public class ArrayTest1 {

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("请输入学生人数：");
        int[] ins = new int[scanner.nextInt()];
        int maxScore = 0;
        for (int i = 0;i<ins.length;i++){
            ins[i] = scanner.nextInt();
            maxScore = i==0?ins[i]:maxScore-ins[i]>=0?maxScore:ins[i];
        }
        System.out.println("最高分为："+maxScore);
        //求出等级
        for (int in : ins) {
            int cha = maxScore-in;
            if(cha<=10){
                System.out.println("分数: "+in+"，等级: A");
            }else if(cha>10 && cha <= 20){
                System.out.println("分数: "+in+"，等级: B");
            }else if(cha>20 && cha <= 30){
                System.out.println("分数: "+in+"，等级: C");
            }else {
                System.out.println("分数: "+in+"，等级: D");
            }

        }



    }

}
