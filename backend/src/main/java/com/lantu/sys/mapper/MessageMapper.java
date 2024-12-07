package com.lantu.sys.mapper;

import com.lantu.sys.entity.Message;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;

import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jiang
 * @since 2024-11-22
 */
public interface MessageMapper extends BaseMapper<Message> {
    public List<Message> getMessageByContent(@Param("str")String str);
}
