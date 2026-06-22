package com.openadmin.plugin.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.common.core.ApiResult;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.plugin.domain.SysPlugin;
import com.openadmin.plugin.service.SysPluginService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/plugin")
public class SysPluginController extends BaseCrudController<SysPlugin> {
    private final SysPluginService service;
    public SysPluginController(SysPluginService service) { this.service = service; }
    @Override
    protected IService<SysPlugin> service() { return service; }

}
