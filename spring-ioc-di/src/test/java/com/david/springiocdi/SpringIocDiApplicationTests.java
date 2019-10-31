package com.david.springiocdi;

import com.david.springiocdi.service.StudentService;
import com.david.springiocdi.service.TeacherService;
import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class SpringIocDiApplicationTests {

    @Test
    public void contextLoads() {
    }

    @Test
    public void testIoc(){
        //创建ApplicationContext(容器)
        /*ApplicationContext context =
                new ClassPathXmlApplicationContext("spring-application.xml");

        StudentService studentService1 = context.getBean(StudentService.class);
        StudentService studentService2 = (StudentService) context.getBean("studentService");

        studentService1.saveStudent();
        studentService2.saveStudent();*/


        ApplicationContext context1 = new AnnotationConfigApplicationContext("com.david.springiocdi.service.*");
        TeacherService teacherService = (TeacherService) context1.getBean("teacherService");
        teacherService.addTeacher();
        TeacherService teacherService1 = (TeacherService) context1.getBean("teacherService");
        teacherService1.addTeacher();

    }

}
