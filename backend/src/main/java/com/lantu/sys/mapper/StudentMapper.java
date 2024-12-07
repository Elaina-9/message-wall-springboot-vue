package com.lantu.sys.mapper;

import com.lantu.sys.entity.Student;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jiang
 * @since 2024-11-05
 */
public interface StudentMapper extends BaseMapper<Student> {
    public List<String> getRoleNameByStudentId(String studentId);
}
