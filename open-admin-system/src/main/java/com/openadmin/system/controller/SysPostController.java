package com.openadmin.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.framework.security.RequiresPermission;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.system.domain.SysPost;
import com.openadmin.system.service.SysPostService;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiresPermission("system:post:list")
@RestController
@RequestMapping("/api/system/post")
public class SysPostController extends BaseCrudController<SysPost> {
    private final SysPostService service;
    public SysPostController(SysPostService service) { this.service = service; }
    @Override
    @RequiresPermission("system:post:list")
    protected IService<SysPost> service() { return service; }
}
