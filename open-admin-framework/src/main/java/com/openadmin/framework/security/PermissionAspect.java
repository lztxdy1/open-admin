package com.openadmin.framework.security;

import com.openadmin.common.exception.BusinessException;
import com.openadmin.common.security.SecurityUser;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class PermissionAspect {
    @Before("@annotation(requiresPermission) || @within(requiresPermission)")
    public void check(RequiresPermission requiresPermission) {
        SecurityUser user = SecurityContextHolder.getUser();
        if (user == null) throw new BusinessException(401, "未登录");
        if (user.isAdmin()) return;
        String permission = requiresPermission.value();
        if (user.getPermissions() == null || !user.getPermissions().contains(permission)) {
            throw new BusinessException(403, "没有操作权限：" + permission);
        }
    }
}
