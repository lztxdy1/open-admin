package com.openadmin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.system.domain.SysConfig;
import com.openadmin.system.mapper.SysConfigMapper;
import com.openadmin.system.service.SysConfigService;
import org.springframework.stereotype.Service;

@Service
public class SysConfigServiceImpl extends ServiceImpl<SysConfigMapper, SysConfig> implements SysConfigService {}
