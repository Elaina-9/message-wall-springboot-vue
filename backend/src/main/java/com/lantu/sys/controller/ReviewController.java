package com.lantu.sys.controller;

import com.lantu.common.vo.Result;
import com.lantu.sys.entity.Liked;
import com.lantu.sys.service.IReviewService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import com.lantu.sys.entity.Review;
import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiang
 * @since 2024-11-25
 */
@RestController
@RequestMapping("/review")
public class ReviewController {
    @Autowired
    private IReviewService reviewService;

    @GetMapping("/all")
    public Result<List<Review>> getReview(){
        List<Review> list = reviewService.list();
        return Result.success(list);
    }

    @PostMapping
    public Result<?> save(@RequestBody Review review){
        reviewService.save(review);
        return Result.success("评论成功");
    }

}
