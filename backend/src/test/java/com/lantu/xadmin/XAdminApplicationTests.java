package com.lantu.xadmin;

import com.lantu.sys.mapper.StudentMapper;
import com.lantu.sys.entity.Student;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

import javax.annotation.Resource;
import java.util.List;

@SpringBootTest
class XAdminApplicationTests {
    @Resource
    private StudentMapper studentMapper;

    @Test
    void contextLoads() {
        List<Student> students = studentMapper.selectList(null);
        students.forEach(System.out::println);
    }
}