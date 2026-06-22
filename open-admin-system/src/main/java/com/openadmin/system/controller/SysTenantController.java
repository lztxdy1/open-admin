package com.openadmin.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.framework.security.RequiresPermission;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.system.domain.SysTenant;
import com.openadmin.system.service.SysTenantService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresPermission("system:tenant:list")
@RestController
@RequestMapping("/api/system/tenant")
public class SysTenantController extends BaseCrudController<SysTenant> {
    private final SysTenantService service;
    public SysTenantController(SysTenantService service) { this.service = service; }
    @Override
    @RequiresPermission("system:tenant:list")
    protected IService<SysTenant> service() { return service; }
}
