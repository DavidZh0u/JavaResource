package com.david.exam.javabase;

/**
 * @ClassName IntegerNumSort
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/6/17 17:12
 */
public class IntegerNumSort {

    public static Integer sortInteger(Integer x){
        if(null == x || 0 == x){
            return 0;
        }

        int result = 0;

        while (x != 0)
        {
            int tail = x % 10;
            int newResult = result * 10 + tail;
            if ((newResult - tail) / 10 != result)
            { return 0; }
            result = newResult;
            x = x / 10;
        }

        return result;
    }

    public static void main(String[] args) {
        Integer i = 345767;
        System.out.println(IntegerNumSort.sortInteger(i));
    }


}
