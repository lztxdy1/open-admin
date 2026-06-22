package com.openadmin.system.service.impl;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.system.domain.SysRoleMenu;
import com.openadmin.system.mapper.SysRoleMenuMapper;
import com.openadmin.system.service.SysRoleMenuService;
import org.springframework.stereotype.Service;

@Service
public class SysRoleMenuServiceImpl extends ServiceImpl<SysRoleMenuMapper, SysRoleMenu> implements SysRoleMenuService {}
