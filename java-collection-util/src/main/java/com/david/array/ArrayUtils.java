package com.david.array;

import java.util.Arrays;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-04 16:46
 */
public class ArrayUtils {

    public static void main(String[] args) {
        int[] int1 = new int[]{12,5,34,23,47};
        int[] int2 = new int[]{12,5,34,23,47};
        int[] int3 = new int[]{5,12,23,34,47,56,61,73,87,97};
        System.out.println(Arrays.equals(int1,int2));

        System.out.println(Arrays.toString(int1));
        Arrays.fill(int1,10);
        System.out.println(Arrays.toString(int1));
        Arrays.sort(int2);
        System.out.println(Arrays.toString(int2));
        int index = Arrays.binarySearch(int3,200);
        System.out.println(index);

    }

}
