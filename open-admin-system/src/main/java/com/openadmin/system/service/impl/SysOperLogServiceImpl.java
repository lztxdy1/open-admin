package com.openadmin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.system.domain.SysOperLog;
import com.openadmin.system.mapper.SysOperLogMapper;
import com.openadmin.system.service.SysOperLogService;
import org.springframework.stereotype.Service;

@Service
public class SysOperLogServiceImpl extends ServiceImpl<SysOperLogMapper, SysOperLog> implements SysOperLogService {}
