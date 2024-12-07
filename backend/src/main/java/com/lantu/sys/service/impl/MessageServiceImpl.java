package com.lantu.sys.service.impl;

import com.lantu.sys.entity.Message;
import com.lantu.sys.mapper.MessageMapper;
import com.lantu.sys.service.IMessageService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import java.util.List;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author jiang
 * @since 2024-11-22
 */
@Service
public class MessageServiceImpl extends ServiceImpl<MessageMapper, Message> implements IMessageService {
    @Override
    public List<Message> search(String Content) {
        return this.baseMapper.getMessageByContent(Content);
    }
}
