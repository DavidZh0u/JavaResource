package com.david.oop;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-06 16:30
 */
public class ZhiChuanDiTest {

    public static void change(User user){
        user = new User(28,"周大伟");
        System.out.println("方法内打印 "+user);
    }

    public static void main(String[] args) {
        User u1 = new User(13,"david");
        change(u1);
        System.out.println(u1);
    }

}
