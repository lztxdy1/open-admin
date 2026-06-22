package com.openadmin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.system.domain.SysTenant;
import com.openadmin.system.mapper.SysTenantMapper;
import com.openadmin.system.service.SysTenantService;
import org.springframework.stereotype.Service;

@Service
public class SysTenantServiceImpl extends ServiceImpl<SysTenantMapper, SysTenant> implements SysTenantService {}
