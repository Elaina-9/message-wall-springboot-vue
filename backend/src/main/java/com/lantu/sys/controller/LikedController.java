package com.lantu.sys.controller;

import com.lantu.common.vo.Result;
import com.lantu.sys.entity.Message;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;

import java.util.List;
import java.util.UUID;

import com.lantu.sys.entity.Liked;
import com.lantu.sys.service.ILikedService;
import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import java.util.Map;
/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiang
 * @since 2024-11-25
 */
@RestController
@RequestMapping("/liked")
public class LikedController {
    @Autowired
    private ILikedService likedService;

    @GetMapping("/all")
    public Result<List<Liked>> getMessage(){
        List<Liked> list = likedService.list();
        return Result.success(list);
    }

    @PostMapping
    public Result<?> save(@RequestBody Liked liked){
        likedService.save(liked);
        return Result.success("点赞成功");
    }

    @DeleteMapping
    public Result<?> deleteLiked(@RequestBody Map<String, String> request) {
        LambdaQueryWrapper<Liked> wrapper = new LambdaQueryWrapper<>();
        wrapper.eq(Liked::getId, request.get("id"))
                .eq(Liked::getTag, request.get("tag"));

        likedService.remove(wrapper);
        return Result.success("取消点赞成功");
    }

}
