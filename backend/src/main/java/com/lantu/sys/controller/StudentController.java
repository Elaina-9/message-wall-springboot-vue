package com.lantu.sys.controller;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import com.lantu.sys.service.IStudentService;
import com.lantu.sys.entity.Student;
import java.util.List;
import com.lantu.common.vo.Result;
import java.util.Map;
import org.springframework.web.bind.annotation.RequestBody;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import java.util.HashMap;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiang
 * @since 2024-11-05
 */
@RestController
@RequestMapping("/student")
// @crossOrigin //跨域处理
public class StudentController {
    @Autowired
    private IStudentService studentService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @GetMapping("/all")
    public Result<List<Student>> getAll(){
        List<Student> list=studentService.list();
        return Result.success(list);
    }

    @PostMapping("/login")
    public Result<Map<String,Object>> login(@RequestBody Student student){
        Map<String,Object> data=studentService.login(student);
        if(data!=null){
            return Result.success(data);
        }
            return Result.fail(20002,"用户名或密码错误");
    }
    @GetMapping("/info")
    public Result<Map<String,Object>> getStudentInfo(@RequestParam("token") String token) {
        Map<String,Object> data=studentService.getStudentInfo(token);
        if(data!=null){
            return Result.success(data);
        }
        return Result.fail(20003,"登录信息无效，请重新登录");
    }

    @PostMapping("/logout")
    public Result<?> logout(@RequestHeader("X-Token") String token){
        studentService.logout(token);
        return Result.success();
    }

    @GetMapping("/list")
    public Result<Map<String,Object>> getUserList(@RequestParam(value="name",required = false) String name,
                                              @RequestParam(value="id",required = false) String id,
                                              @RequestParam(value="pageNo") Long pageNo,
                                              @RequestParam(value="pageSize") Long pageSize){
        LambdaQueryWrapper<Student> wrapper=new LambdaQueryWrapper<>();
        wrapper.eq(StringUtils.hasLength(name),Student::getName,name);
        wrapper.eq(StringUtils.hasLength(id),Student::getId,id);
       // wrapper.orderByDesc(Student::getId);

        Page<Student> page =  new Page<>(pageNo,pageSize);
        studentService.page(page,wrapper);

        Map<String,Object> data=new HashMap<>();
        data.put("total",page.getTotal());
        data.put("rows",page.getRecords());

        return Result.success(data);
    }
    @PostMapping
    public Result<?> addUser(@RequestBody Student student){
        student.setPassword(passwordEncoder.encode(student.getPassword()));
        studentService.save(student);
       return Result.success("新增用户成功");
    }

    @PutMapping
    public Result<?> updateUser(@RequestBody Student student){
        student.setPassword(null);
        studentService.updateById(student);
        return Result.success("修改用户成功");
    }

    @GetMapping("/{id}")
    public Result<Student> getUserById(@PathVariable("id") String id){
        Student student=studentService.getById(id);
        return Result.success(student);
    }
    @DeleteMapping("/{id}")
    public Result<Student> deleteUserById(@PathVariable("id") String id){
        studentService.removeById(id);
        return Result.success("删除用户成功");
    }

}
