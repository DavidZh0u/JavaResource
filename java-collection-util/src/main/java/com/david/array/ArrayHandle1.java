package com.david.array;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-03 22:54
 */
public class ArrayHandle1 {

    private int[] array;
    private int length;

    public ArrayHandle1(int length){
        this.length = length;
        this.array = initArray();
    }

    public int[] initArray(){
        int[] array = new int[this.length];
        for (int i = 0; i < array.length; i++) {
            array[i] = getNum();
        }
        return array;
    }

    public static int getNum(){
        return (int)(Math.random()*99+1);
    }


    public int[] copyArray(){
        int[] newArray = new int[array.length];
        for (int i = 0; i < newArray.length; i++) {
            newArray[i] = array[i];
        }
        return newArray;
    }

    public void reDirecation(){
        int legth = array.length;
        for (int i = 0; i < legth/2 ; i++) {
            int flag = array[i];
            array[i] = array[array.length-1-i];
            array[array.length-1-i] = flag;
        }
    }

    public static void main(String[] args) {
        System.out.println("数组的复制操作=======================================");
        ArrayHandle1 arrayHandle1 = new ArrayHandle1(20);
        int[] newArray = arrayHandle1.copyArray();
        newArray[2] = 0;
        newArray[4] = 0;
        System.out.println(newArray);
        for (int i : newArray) {
            System.out.print(i + " ");
        }
        System.out.println();
        System.out.println(arrayHandle1.array);
        for (int i : arrayHandle1.array) {
            System.out.print(i + " ");
        }
        System.out.println();

        System.out.println("数组的逆反操作=======================================");
        arrayHandle1.reDirecation();
        System.out.println(arrayHandle1.array);
        for (int i : arrayHandle1.array) {
            System.out.print(i + " ");
        }

        System.out.println();
        System.out.println("数组的查找操作=======================================");
        int flag = 10;
        //线性查找
        boolean result = false;
        for (int i = 0; i < arrayHandle1.array.length; i++) {
            if(flag==arrayHandle1.array[i]){
                System.out.println("线性查找---查找到该元素->"+flag+"，位置："+i);
                result = true;
                break;
            }
        }
        if(!result){
            System.out.println("线性查找---没有找到该元素："+flag);
        }

        //二分查找
        //前提：数组先有序
        int[] arraySorted = new int[]{12,34,45,46,56,59,67,78,89,91,92,93,94,96,101,102,103,104,105,106};
        for (int i : arraySorted) {
            System.out.print(i + " ");
        }
        System.out.println();
        int queryNum = 92;
        int head = 0;
        int end = arraySorted.length - 1;
        boolean result2 = false;
        while (head<=end){
            int mid = (head+end)/2;
            System.out.println("head = "+head+" , end = "+end+" , mid = "+mid);
            if(queryNum==arraySorted[mid]){
                result2 = true;
                System.out.println("二分查找---找到了指定元素["+queryNum+"],位置为："+mid);
                break;
            }else if(arraySorted[mid] > queryNum){
                end = mid - 1;
            }else {
                head = mid + 1;
            }
        }
        if(!result2){
            System.out.println("二分查找---没有找到了指定元素["+queryNum+"]");
        }

    }

}
