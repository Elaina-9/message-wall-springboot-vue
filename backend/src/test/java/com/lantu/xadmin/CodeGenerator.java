package com.lantu.xadmin;
import com.baomidou.mybatisplus.generator.FastAutoGenerator;
import com.baomidou.mybatisplus.generator.config.OutputFile;
import com.baomidou.mybatisplus.generator.engine.FreemarkerTemplateEngine;

import  java.util.Collections;

public class CodeGenerator {
    public static void main(String[] args) {
        String url="jdbc:mysql://localhost:3306/test";
        String username="root"; // 数据库用户名
        String password="123456"; // 数据
        String moduleName="sys"; // 模块名
        String mapperLocation="C:\\Users\\dell\\x-admin\\src\\main\\resources\\mapper\\"+moduleName; // mapper.xml生成路径
        String table="";//表名，逗号分割
        FastAutoGenerator.create(url, username, password)
                .globalConfig(builder -> {
                    builder.author("jiang") // 设置作者
                            //.enableSwagger() // 开启 swagger 模式
                            .outputDir("C:\\Users\\dell\\x-admin\\src\\main\\java"); // 指定输出目录
                })
                .packageConfig(builder ->
                        builder.parent("com.lantu") // 设置父包名
                                .moduleName(moduleName) // 设置父包模块名
                                .pathInfo(Collections.singletonMap(OutputFile.xml, mapperLocation)) // 设置mapperXml生成路径
                )
                .strategyConfig(builder ->
                        builder.addInclude("avatar") // 设置需要生成的表名
                )
                .templateEngine(new FreemarkerTemplateEngine()) // 使用Freemarker引擎模板，默认的是Velocity引擎模板
                .execute();
    }
}
