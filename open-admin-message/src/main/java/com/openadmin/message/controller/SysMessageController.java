package com.openadmin.message.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.common.core.ApiResult;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.message.domain.SysMessage;
import com.openadmin.message.service.SysMessageService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/message")
public class SysMessageController extends BaseCrudController<SysMessage> {
    private final SysMessageService service;
    public SysMessageController(SysMessageService service) { this.service = service; }
    @Override
    protected IService<SysMessage> service() { return service; }

}
