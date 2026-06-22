package com.openadmin.message.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.message.domain.SysMessage;
import com.openadmin.message.mapper.SysMessageMapper;
import com.openadmin.message.service.SysMessageService;
import org.springframework.stereotype.Service;
@Service
public class SysMessageServiceImpl extends ServiceImpl<SysMessageMapper, SysMessage> implements SysMessageService {}
