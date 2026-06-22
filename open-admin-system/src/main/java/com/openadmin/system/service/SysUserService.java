package com.openadmin.system.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.openadmin.common.security.SecurityUser;
import com.openadmin.system.domain.SysUser;

public interface SysUserService extends IService<SysUser> {
    SecurityUser login(String username, String password);
    SecurityUser loadSecurityUser(SysUser user);
}
