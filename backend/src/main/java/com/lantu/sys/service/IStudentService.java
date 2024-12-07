package com.lantu.sys.service;

import com.baomidou.mybatisplus.core.conditions.Wrapper;
import com.lantu.sys.entity.Student;
import com.baomidou.mybatisplus.extension.service.IService;

import java.util.Map;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiang
 * @since 2024-11-05
 */
public interface IStudentService extends IService<Student> {
    Map<String, Object> login(Student student);
    Map<String, Object> getStudentInfo(String token);
    void logout(String token);
}
