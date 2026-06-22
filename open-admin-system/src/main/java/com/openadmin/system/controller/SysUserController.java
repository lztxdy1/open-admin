package com.openadmin.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.framework.security.RequiresPermission;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.system.domain.SysUser;
import com.openadmin.system.service.SysUserService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresPermission("system:user:list")
@RestController
@RequestMapping("/api/system/user")
public class SysUserController extends BaseCrudController<SysUser> {
    private final SysUserService service;
    public SysUserController(SysUserService service) { this.service = service; }
    @Override
    @RequiresPermission("system:user:list")
    protected IService<SysUser> service() { return service; }
}
