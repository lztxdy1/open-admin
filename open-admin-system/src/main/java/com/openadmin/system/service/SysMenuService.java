package com.openadmin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.system.domain.SysMenu;
import java.util.List;

public interface SysMenuService extends IService<SysMenu> {
    List<SysMenu> selectRoutes(Long userId, boolean admin);
}
