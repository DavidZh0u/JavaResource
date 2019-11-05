package com.david.array;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-02 15:59
 */
public class ArrayTest {

    public static void main(String[] args) {
        //静态初始化
        int[] ids = new int[]{1,2,3,4};
        //动态初始化
        String[] strs = new String[5];
        strs[0] = "1";
        for (String str : strs) {
            System.out.println(str);
        }
        System.out.println(strs.hashCode());

        double[] ds = new double[5];
        for (double d : ds) {
            System.out.println(d);
        }

        char[] cs = new char[5];
        for (char c : cs) {
            if(c == 0){
                System.out.println("-"+c+"*");
            }

        }

        boolean[] bs = new boolean[5];
        for (boolean b : bs) {
            System.out.println(b);
        }

    }

}
