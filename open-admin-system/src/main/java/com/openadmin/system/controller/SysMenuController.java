package com.openadmin.system.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.common.core.ApiResult;
import com.openadmin.common.security.SecurityUser;
import com.openadmin.framework.security.RequiresPermission;
import com.openadmin.framework.security.SecurityContextHolder;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.system.domain.SysMenu;
import com.openadmin.system.service.SysMenuService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiresPermission("system:menu:list")
@RestController
@RequestMapping("/api/system/menu")
public class SysMenuController extends BaseCrudController<SysMenu> {
    private final SysMenuService service;
    public SysMenuController(SysMenuService service) { this.service = service; }
    @Override
    @RequiresPermission("system:menu:list")
    protected IService<SysMenu> service() { return service; }

    @GetMapping("/routes")
    public ApiResult<List<SysMenu>> routes() {
        SecurityUser user = SecurityContextHolder.getUser();
        return ApiResult.ok(service.selectRoutes(user.getUserId(), user.isAdmin()));
    }
}
