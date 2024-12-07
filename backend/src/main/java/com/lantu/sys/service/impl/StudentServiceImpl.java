package com.lantu.sys.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.lantu.sys.entity.Student;
import com.lantu.sys.mapper.StudentMapper;
import com.lantu.sys.service.IStudentService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import java.util.Map;
import java.util.UUID;
import java.util.HashMap;
import java.util.concurrent.TimeUnit;
import com.alibaba.fastjson2.JSON;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiang
 * @since 2024-11-05
 */
@Service
public class StudentServiceImpl extends ServiceImpl<StudentMapper, Student> implements IStudentService {
    @Autowired
    private RedisTemplate redisTemplate;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Override
    public Map<String, Object> login(Student student) {
        //查询
        LambdaQueryWrapper<Student> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(Student::getId,student.getId());
      //  wrapper.eq(Student::getPassword,student.getPassword());
        Student loginStudent=this.baseMapper.selectOne(wrapper);

        if(loginStudent!=null&&passwordEncoder.matches(student.getPassword(),loginStudent.getPassword())){
            String key="Student:"+UUID.randomUUID()+"Pass:"+loginStudent.getPassword();
            //存储到redis
         //       loginStudent.setPassword(null);
                redisTemplate.opsForValue().set(key,loginStudent,30, TimeUnit.MINUTES);
                System.out.println("key:"+key);

            //返回
            Map<String,Object> data=new HashMap<>();
            data.put("token",key);
            return data;
        }
        return null;
    }

    @Override
    public Map<String, Object> getStudentInfo(String token) {
        Object obj= redisTemplate.opsForValue().get(token);
        if(obj!=null){
            Student loginStudent=JSON.parseObject(JSON.toJSONString(obj),Student.class);
            Map<String,Object> data=new HashMap<>();
            data.put("id",loginStudent.getId());
            data.put("password",loginStudent.getPassword());
            data.put("name",loginStudent.getName());
            data.put("nickname",loginStudent.getNickname());
            data.put("age",loginStudent.getAge());
            data.put("status",loginStudent.getStatus());
            data.put("role",loginStudent.getRole());
            data.put("sex",loginStudent.getSex());
            return data;
        }
        return null;
    }

    @Override
    public void logout(String token){
        redisTemplate.delete(token);
    }

}
