package com.openadmin.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.framework.security.RequiresPermission;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.system.domain.SysLoginLog;
import com.openadmin.system.service.SysLoginLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresPermission("monitor:loginlog:list")
@RestController
@RequestMapping("/api/system/loginlog")
public class SysLoginLogController extends BaseCrudController<SysLoginLog> {
    private final SysLoginLogService service;
    public SysLoginLogController(SysLoginLogService service) { this.service = service; }
    @Override
    @RequiresPermission("monitor:loginlog:list")
    protected IService<SysLoginLog> service() { return service; }
}
