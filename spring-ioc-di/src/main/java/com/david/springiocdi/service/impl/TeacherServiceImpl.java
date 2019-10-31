package com.david.springiocdi.service.impl;

import com.david.springiocdi.service.TeacherService;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

@Service(value = "teacherService")
@Scope(value = "prototype")
public class TeacherServiceImpl implements TeacherService {

    private Integer num = 0 ;

    @Override
    public void addTeacher() {
        num++;
        System.out.println("这个老师有点狂..."+num);
    }
}
