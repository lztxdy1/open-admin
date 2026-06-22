package com.openadmin.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.framework.security.RequiresPermission;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.system.domain.SysOperLog;
import com.openadmin.system.service.SysOperLogService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresPermission("monitor:operlog:list")
@RestController
@RequestMapping("/api/system/operlog")
public class SysOperLogController extends BaseCrudController<SysOperLog> {
    private final SysOperLogService service;
    public SysOperLogController(SysOperLogService service) { this.service = service; }
    @Override
    @RequiresPermission("monitor:operlog:list")
    protected IService<SysOperLog> service() { return service; }
}
