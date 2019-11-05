package com.david.array;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-03 19:42
 */
public class HuiXingShu {

    private static int num = 1;
    private static int direcation = 1;
    private static int x = 0;
    private static int y = 0;

    public static int[][] getInts(int n){
        int[][] array = new int[n][n];
        for (int i = n; i >= 0 ; i--) {
            if(i==n){
                for(int k = 0 ; k < i ; k++){
                    array[0][k] = num++;
                    y = k;
                }
                direcation++;
            }else {
                int diracationFlag1 = getDirection();
                handle(array,i,diracationFlag1,x,y);
                int diracationFlag2 = getDirection();
                handle(array,i,diracationFlag2,x,y);
            }
        }
        return array;
    }

    public static void handle(int[][] array,int i,int flag,int m,int n){
        switch (flag){
            case 1:
                for (int j=0;j<i;j++){
                    y = ++n;
                    array[m][y] = num++;
                }
                break;
            case 2:
                for (int j=0;j<i;j++){
                    x = ++m;
                    array[x][n] = num++;
                }
                break;
            case 3:
                for (int j=0;j<i;j++){
                    y = --n;
                    array[m][y] = num++;
                }
                break;
            case 4:
                for (int j=0;j<i;j++){
                    x = --m;
                    array[x][n] = num++;
                }
                break;
            default:
                break;
        }
    }



    public static int getDirection(){
        if(direcation>4){
            direcation = 1;
        }
        return direcation++;
    }

    public static void main(String[] args) {
        int[][] ints = getInts(6);
        for (int[] anInt : ints) {
            for (int i : anInt) {
                System.out.print(String.valueOf(i).length()>1?i+" ":"0"+i+" ");
            }
            System.out.println();
        }
    }

}
