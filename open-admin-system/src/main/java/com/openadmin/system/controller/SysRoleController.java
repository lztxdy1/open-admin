package com.openadmin.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.framework.security.RequiresPermission;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.system.domain.SysRole;
import com.openadmin.system.service.SysRoleService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresPermission("system:role:list")
@RestController
@RequestMapping("/api/system/role")
public class SysRoleController extends BaseCrudController<SysRole> {
    private final SysRoleService service;
    public SysRoleController(SysRoleService service) { this.service = service; }
    @Override
    @RequiresPermission("system:role:list")
    protected IService<SysRole> service() { return service; }
}
