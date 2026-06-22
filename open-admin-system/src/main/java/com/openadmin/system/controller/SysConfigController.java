package com.openadmin.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.framework.security.RequiresPermission;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.system.domain.SysConfig;
import com.openadmin.system.service.SysConfigService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresPermission("system:config:list")
@RestController
@RequestMapping("/api/system/config")
public class SysConfigController extends BaseCrudController<SysConfig> {
    private final SysConfigService service;
    public SysConfigController(SysConfigService service) { this.service = service; }
    @Override
    @RequiresPermission("system:config:list")
    protected IService<SysConfig> service() { return service; }
}
