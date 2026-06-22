package com.openadmin.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.framework.security.RequiresPermission;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.system.domain.SysDictType;
import com.openadmin.system.service.SysDictTypeService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresPermission("system:dict:list")
@RestController
@RequestMapping("/api/system/dict/type")
public class SysDictTypeController extends BaseCrudController<SysDictType> {
    private final SysDictTypeService service;
    public SysDictTypeController(SysDictTypeService service) { this.service = service; }
    @Override
    @RequiresPermission("system:dict:list")
    protected IService<SysDictType> service() { return service; }
}
