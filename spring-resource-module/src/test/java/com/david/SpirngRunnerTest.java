package com.david;

import com.david.service.StudentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = "classpath:applicationContext.xml")
public class SpirngRunnerTest {

    @Autowired
    private StudentService studentService;

    @Test
    public void saveStudent(){
        studentService.saveStudent();
    }

}
