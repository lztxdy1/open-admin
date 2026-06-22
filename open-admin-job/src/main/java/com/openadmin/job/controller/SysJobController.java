package com.openadmin.job.controller;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.common.core.ApiResult;
import com.openadmin.framework.web.BaseCrudController;
import com.openadmin.job.domain.SysJob;
import com.openadmin.job.service.SysJobService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/job")
public class SysJobController extends BaseCrudController<SysJob> {
    private final SysJobService service;
    public SysJobController(SysJobService service) { this.service = service; }
    @Override
    protected IService<SysJob> service() { return service; }

    @PostMapping("/run/{id}")
    public ApiResult<String> run(@PathVariable Long id) {
        SysJob job = service.getById(id);
        return ApiResult.ok("任务已触发：" + (job == null ? id : job.getJobName()));
    }

}
