package com.lantu.sys.controller;

import com.lantu.common.vo.Result;
import com.lantu.sys.entity.Liked;
import com.lantu.sys.entity.Student;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import org.springframework.stereotype.Controller;
import org.springframework.web.multipart.MultipartFile;
import org.springframework.http.ResponseEntity;
import java.io.File;
import java.util.List;
import java.util.UUID;
import org.springframework.http.HttpStatus;
import com.lantu.sys.service.IAvatarService;
import com.lantu.sys.entity.Avatar;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author jiang
 * @since 2024-11-27
 */
@RestController
@RequestMapping("/avatar")
public class AvatarController {

    // 文件保存路径
    private static final String UPLOAD_PATH = "D:\\message-wall-springboot+vue\\frontend\\public\\avatars\\";

    @Autowired
    private IAvatarService avatarService;

    @PostMapping
    public Result<?> save(@RequestBody Avatar avatar){
        avatarService.save(avatar);
        return Result.success("上传照片成功");
    }

    @GetMapping("/all")
    public Result<List<Avatar>> getAll(){
        List<Avatar> list=avatarService.list();
        return Result.success(list);
    }

    @PostMapping("/image")
    public ResponseEntity<String> uploadImage(@RequestParam("file") MultipartFile file) {
        try {
            // 检查文件是否为空
            if (file.isEmpty()) {
                return ResponseEntity.badRequest().body("请选择文件");
            }

            // 生成唯一文件名
            String originalFilename = file.getOriginalFilename();
            String fileExtension = originalFilename.substring(originalFilename.lastIndexOf("."));
            String uniqueFileName = UUID.randomUUID().toString() + fileExtension;

            // 创建目标文件
            File destFile = new File(UPLOAD_PATH + uniqueFileName);

            // 确保目录存在
            if (!destFile.getParentFile().exists()) {
                destFile.getParentFile().mkdirs();
            }

            // 保存文件
            file.transferTo(destFile);

            // 返回文件访问URL
            String fileUrl =  uniqueFileName;
            return ResponseEntity.ok(fileUrl);

        } catch (Exception e) {
            e.printStackTrace();
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body("上传失败");
        }
    }
}
