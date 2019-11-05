package com.david.oop;

/**
 * @author zhoudawei
 * @mail zdw0607@gmail.com
 * @date 2019-11-04 21:27
 */
public class JuXing {

    public int getJu(int m,int n){
        for (int i = 0; i <m; i++) {
            for (int j = 0; j <n ; j++) {
                System.out.print("* ");
            }
            System.out.println();
        }
        return m*n;
    }

    public static int getState(){
        return (int)(Math.random() * 6 + 1);
    }

    public static int getScore(){
        return (int)(Math.random() * 101);
    }

    static class Student{
        int number;
        int state;
        int score;

        @Override
        public String toString(){
            return "学号："+number+"，年级："+state+"，分数："+score;
        }
    }

    public static void main(String[] args) {
        JuXing xing = new JuXing();
        System.out.println(xing.getJu(5,6));
        //
        Student[] stus = new Student[20];
        for (int i = 0; i < stus.length; i++) {
            Student student = new Student();
            student.number = i + 1;
            student.state = getState();
            student.score = getScore();
            stus[i] = student;
        }

        for (Student student : stus) {
            System.out.println(student);
        }
        System.out.println("=============================================");

        for (Student student : stus) {
            if(student.state == 3){
                System.out.println(student);
            }
        }

        System.out.println("=================================================");
        //排序
        for (int i = 0; i < stus.length-1; i++) {
            for (int j = 0; j < stus.length - 1 - i ; j++) {
                if(stus[j].score > stus[j+1].score){
                    Student temp = stus[j+1];
                    stus[j+1] = stus[j];
                    stus[j] = temp;
                }
            }
        }
        for (Student student : stus) {
            System.out.println(student);
        }
    }



}
