package com.david.array;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-03 17:14
 */
public class ArraySanJiao {

    public static int[][] getSanJiao(int n){
        if(n<=0){
            System.out.println("请输入一个正整数");
            return null;
        }
        int[][] ints = new int[n][];
        for(int i = 0,m;i < n;i++){
            m = i;
            int[] newArray = new int[m+1];
            for (int j = 0;j <= m;j++){
                if(j == 0){
                    newArray[j] = 1;
                }else if(j == m){
                    newArray[j] = 1;
                }else {
                    newArray[j] = ints[i-1][j-1] + ints[i-1][j];                    }
            }
            ints[i] = newArray;
        }
        return ints;
    }

    public static int[][] getBaoTa(int n){
        if(n<=0){
            System.out.println("请输入一个正整数");
            return null;
        }
        int[][] ints = new int[n][2*n-1];
        int mid = n-1;
        for (int i = 0;i < n ;i++){
            for (int j = 0; j <= i ; j++) {
                if (j == i){
                    ints[i][mid] = (int)Math.pow(2,i);
                }else {
                    ints[i][mid-j-1] = (int)Math.pow(2,i-j-1);
                    ints[i][mid+j+1] = (int)Math.pow(2,i-j-1);
                }
            }
        }


        return ints;
    }

    public static void main(String[] args) {
//        int[][] ints = getSanJiao(10);
        int[][] ints = getBaoTa(11);
        if(ints != null){
            for (int[] anInt : ints) {
                for (int i : anInt) {
                    if(i == 0){
                        System.out.print("    "+" ");
                    }else {
                        if(String.valueOf(i).length()==1){
                            System.out.print("000"+i+" ");
                        }else if(String.valueOf(i).length()==2){
                            System.out.print("00"+i+" ");
                        }else if(String.valueOf(i).length()==3){
                            System.out.print("0"+i+" ");
                        }else {
                            System.out.print(i+" ");
                        }

                    }
                }
                System.out.println();
            }
        }
    }

}
