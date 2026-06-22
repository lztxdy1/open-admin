package com.openadmin.plugin.service.impl;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.plugin.domain.SysPlugin;
import com.openadmin.plugin.mapper.SysPluginMapper;
import com.openadmin.plugin.service.SysPluginService;
import org.springframework.stereotype.Service;
@Service
public class SysPluginServiceImpl extends ServiceImpl<SysPluginMapper, SysPlugin> implements SysPluginService {}
