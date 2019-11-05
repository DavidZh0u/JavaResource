package com.david.test;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-01 17:03
 */
public class VariableTest {
    public static void main(String[] args) {
        int k = 32;
        int sum = 1;
        for (int i = 0; i <k ; i++) {
            sum = sum * 2;
        }
        System.out.println(sum);
    }
}
