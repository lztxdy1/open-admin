package com.openadmin.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.framework.security.RequiresPermission;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.system.domain.SysDictData;
import com.openadmin.system.service.SysDictDataService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresPermission("system:dict:list")
@RestController
@RequestMapping("/api/system/dict/data")
public class SysDictDataController extends BaseCrudController<SysDictData> {
    private final SysDictDataService service;
    public SysDictDataController(SysDictDataService service) { this.service = service; }
    @Override
    @RequiresPermission("system:dict:list")
    protected IService<SysDictData> service() { return service; }
}
