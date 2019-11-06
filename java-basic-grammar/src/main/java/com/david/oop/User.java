package com.david.oop;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-06 16:27
 */
public class User {

    public int age;
    public String name;

    public User(int age,String name){
        this.age = age;
        this.name = name;
    }

    @Override
    public String toString(){
        return "User[age = "+age+" , name = "+name+"]";
    }

}
