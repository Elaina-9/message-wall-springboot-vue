package com.lantu.sys.service;

import com.lantu.sys.entity.Message;
import com.baomidou.mybatisplus.extension.service.IService;
import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author jiang
 * @since 2024-11-22
 */
public interface IMessageService extends IService<Message> {
    List<Message> search(String Content);
}
