package com.lantu.sys.mapper;

import com.lantu.sys.entity.Avatar;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.lantu.sys.entity.Avatar;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author jiang
 * @since 2024-11-27
 */
public interface AvatarMapper extends BaseMapper<Avatar> {
    void insertFileInfo(Avatar fileInfo);
}
