package com.openadmin.framework.web;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.common.core.ApiResult;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;
import java.util.List;

public abstract class BaseCrudController<T> {
    protected abstract IService<T> service();

    @GetMapping("/list")
    public ApiResult<List<T>> list() { return ApiResult.ok(service().list()); }

    @GetMapping("/{id}")
    public ApiResult<T> get(@PathVariable Serializable id) { return ApiResult.ok(service().getById(id)); }

    @PostMapping
    public ApiResult<T> add(@RequestBody T entity) {
        service().save(entity);
        return ApiResult.ok(entity);
    }

    @PutMapping
    public ApiResult<T> edit(@RequestBody T entity) {
        service().updateById(entity);
        return ApiResult.ok(entity);
    }

    @DeleteMapping("/{id}")
    public ApiResult<Void> remove(@PathVariable Serializable id) {
        service().removeById(id);
        return ApiResult.ok();
    }
}
