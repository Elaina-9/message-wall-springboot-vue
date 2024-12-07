package com.lantu.sys.controller;

import com.lantu.sys.entity.Student;
import com.lantu.sys.service.IMessageService;
import com.lantu.sys.service.IStudentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.lantu.common.vo.Result;
import com.lantu.sys.entity.Message;
import java.util.List;
import org.springframework.security.crypto.password.PasswordEncoder;
import java.util.UUID;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiang
 * @since 2024-11-22
 */
@RestController
@RequestMapping("/message")
public class MessageController {
    @Autowired
    private IMessageService messageService;

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private IStudentService studentService;

    @GetMapping("/all")
    public Result<List<Message>> getMessage(){
        List<Message> list = messageService.list();
        return Result.success(list);
    }

    @PostMapping
    public Result<?> save(@RequestBody Message message){
        String tag=UUID.randomUUID().toString();
        message.setTag(tag);
        messageService.save(message);
        return Result.success(tag);
    }

    @PutMapping
    public Result<?> updateUser(@RequestBody Student student){
        //""和null不相同
        if(student.getPassword()!=""){
        student.setPassword(passwordEncoder.encode(student.getPassword()));}
        else{
            student.setPassword(null);
        }

        studentService.updateById(student);
        return Result.success("修改个人信息成功");
    }
    //按条件查询留言
    @GetMapping("/search")
    public Result<List<Message>> search(@RequestParam(value="content") String content){
        List<Message> list = messageService.search(content);
        return Result.success(list);
    }

}
