package com.david.oop;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-04 21:15
 */
public class Circle {

    public static double pi = Math.PI;

    public double radius;

    public Circle(double r){
        radius = r;
    }

    public double getArea(){
        return pi*radius*radius;
    }

    public static void main(String[] args) {
        Circle circle = new Circle(3);
        System.out.println(circle.getArea());
    }

}
