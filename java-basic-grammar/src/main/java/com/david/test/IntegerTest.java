package com.david.test;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-02 15:38
 */
public class IntegerTest {

    public static void main(String[] args) {
        Integer i1 = new Integer(123456789);
        System.out.println(Integer.toBinaryString(i1));
        System.out.println(Integer.toOctalString(i1));
        System.out.println(Integer.toHexString(i1));

        int i2 = 0b111010110111100110100010101;
        int i8 = 0726746425;
        int i16 = 0x75bcd15;

        System.out.println(i2);
        System.out.println(i8);
        System.out.println(i16);


    }

}
