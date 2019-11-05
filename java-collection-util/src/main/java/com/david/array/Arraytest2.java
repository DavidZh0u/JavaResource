package com.david.array;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-02 17:57
 */
public class Arraytest2 {
    public static void main(String[] args) {
        //二维数组
        String[][] strs = new String[2][3];
        int i = 0;
        for (String[] str : strs) {
            int x = i++;
            int j = 0;
            for (String s : str) {
                int y = j++;
                strs[x][y] = "char-"+x+"-"+y;
            }
        }
        for (String[] str : strs) {
            for (String s : str) {
                System.out.println(s);
            }
        }

        System.out.println("---------------------------------------------------------------");
        //三维数组
        int[][][] int3s = new int[3][3][3];
        int a = 0,b = 0,c = 0,num = 1;
        for (int[][] int2s : int3s) {
            for (int[] int1s : int2s) {
                for (int node : int1s) {
                    int3s[a][b][c] = num++;
                    c++;
                }
                b++;
                c = 0;
            }
            a++;
            b = 0;
        }

        for (int[][] int3 : int3s) {
            for (int[] ints : int3) {
                for (int anInt : ints) {
                    System.out.println(anInt);
                }
            }
        }
        System.out.println(int3s[0]);
        System.out.println("3x3x3数组长度："+int3s.length);

    }

}
