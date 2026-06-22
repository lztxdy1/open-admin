package com.openadmin.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.framework.security.RequiresPermission;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.system.domain.SysDept;
import com.openadmin.system.service.SysDeptService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresPermission("system:dept:list")
@RestController
@RequestMapping("/api/system/dept")
public class SysDeptController extends BaseCrudController<SysDept> {
    private final SysDeptService service;
    public SysDeptController(SysDeptService service) { this.service = service; }
    @Override
    @RequiresPermission("system:dept:list")
    protected IService<SysDept> service() { return service; }
}
