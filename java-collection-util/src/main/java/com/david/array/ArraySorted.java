package com.david.array;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-04 14:20
 */
public class ArraySorted {

    private int[] array;
    private int length;

    public ArraySorted(int length){
        this.length = length;
        this.array = initArray();
    }

    public int[] initArray(){
        int[] array = new int[this.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = getNum();
            System.out.print(array[i] + " ");
        }
        return array;
    }

    public static int getNum(){
        return (int)(Math.random()*99+1);
    }

    //冒泡排序
    public void paoSort(){
        long timeStart = System.currentTimeMillis();
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-1-i; j++) {
                if(array[j]>array[j+1]){
                    int flag = array[j+1];
                    array[j+1] = array[j];
                    array[j] = flag;
                }
            }
        }
        long time = System.currentTimeMillis() - timeStart;
        System.out.println("快速排序耗时："+time);
    }

    //快速排序
    public void fastSort(int[] data,int start,int end){
        if(start < end){
            int base = data[start];
            int low = start;
            int high = end + 1;
            while (true){
                while (low < end && data[++low] - base <= 0){ }
                while (high > start && data[--high] - base >= 0){ }
                if(low < high){
                    swap(data,low,high);
                }else{
                    break;
                }
            }
            swap(data,start,high);
            //递归
            fastSort(data,start,high - 1);
            fastSort(data,high + 1,end);
        }
    }

    public static void swap(int[] array,int a ,int b){
        int temp = array[a];
        array[a] = array[b];
        array[b] = temp;
    }

    public static void main(String[] args) {
        ArraySorted as = new ArraySorted(20);
        System.out.println();
        as.paoSort();
        for (int i : as.array) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println("=========================================");
        ArraySorted as1 = new ArraySorted(20);
        System.out.println();
        long startTime = System.currentTimeMillis();
        as.fastSort(as1.array,0,as1.array.length-1);
        System.out.println("快速排序耗时 ："+ (System.currentTimeMillis() - startTime));
        for (int i : as1.array) {
            System.out.print(i + " ");
        }
    }

}
