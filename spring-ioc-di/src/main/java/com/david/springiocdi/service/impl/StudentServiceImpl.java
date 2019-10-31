package com.david.springiocdi.service.impl;

import com.david.springiocdi.service.StudentService;
import org.springframework.stereotype.Service;

/**
 * @ClassName StudentServiceImpl
 * @Description TODO
 * @Author ZHOUDAWEI001
 * @Date 2019/5/22 15:59
 */
public class StudentServiceImpl implements StudentService {
    @Override
    public void saveStudent() {
        System.out.println("保存学生Service实现");
    }

    public StudentServiceImpl(Integer id,String name){
        System.out.println("学生编号："+id+",姓名："+name);
    }

    public StudentServiceImpl(){
        System.out.println("无参构造器");
    }
}
