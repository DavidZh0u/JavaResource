package com.david.array;

import java.util.Random;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-03 19:00
 */
public class LotteryTicket {

    public static final Random random = new Random(47);

    public static int getNum(){
        return random.nextInt(30)+1;
    }

    public static String getTicket(){
       int[] ints = new int[6];
       StringBuffer sb = new StringBuffer();
        for (int i = 0; i < 6 ; i++) {
            if(i==0){
                ints[i] = getNum();
            }else {
                boolean numExist = true;
                while (numExist){
                    int num = getNum();
                    numExist = validateExist(num, ints);
                    if(!numExist){
                        ints[i] = num;
                    }
                }
            }
            sb.append(String.valueOf(ints[i]).length()>1?String.valueOf(ints[i]):"0"+String.valueOf(ints[i]));
            sb.append(" ");
        }
        return sb.toString();
    }

    public static boolean validateExist(int num , int[] ints){
        for (int anInt : ints) {
            if (anInt == num){
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            System.out.println(getTicket());
        }

    }

}
