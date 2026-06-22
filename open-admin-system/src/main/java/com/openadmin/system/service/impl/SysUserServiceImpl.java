package com.openadmin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.common.exception.BusinessException;
import com.openadmin.common.security.SecurityUser;
import com.openadmin.common.utils.PasswordUtils;
import com.openadmin.system.domain.SysRole;
import com.openadmin.system.domain.SysUser;
import com.openadmin.system.mapper.SysMenuMapper;
import com.openadmin.system.mapper.SysRoleMapper;
import com.openadmin.system.mapper.SysUserMapper;
import com.openadmin.system.service.SysUserService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysUserServiceImpl extends ServiceImpl<SysUserMapper, SysUser> implements SysUserService {
    private final SysRoleMapper roleMapper;
    private final SysMenuMapper menuMapper;
    public SysUserServiceImpl(SysRoleMapper roleMapper, SysMenuMapper menuMapper) {
        this.roleMapper = roleMapper;
        this.menuMapper = menuMapper;
    }

    @Override
    public SecurityUser login(String username, String password) {
        SysUser user = getOne(new LambdaQueryWrapper<SysUser>().eq(SysUser::getUsername, username).last("limit 1"));
        if (user == null) throw new BusinessException(401, "账号不存在");
        if (user.getStatus() != null && user.getStatus() != 1) throw new BusinessException(401, "账号已停用");
        if (!PasswordUtils.matches(password, user.getPassword())) throw new BusinessException(401, "密码错误");
        return loadSecurityUser(user);
    }

    @Override
    public SecurityUser loadSecurityUser(SysUser user) {
        SecurityUser securityUser = new SecurityUser();
        securityUser.setUserId(user.getId());
        securityUser.setUsername(user.getUsername());
        securityUser.setNickname(user.getNickname());
        securityUser.setDeptId(user.getDeptId());
        securityUser.setTenantId(user.getTenantId());
        securityUser.setAdmin(user.getId() != null && user.getId() == 1L);
        List<SysRole> roles = roleMapper.selectRolesByUserId(user.getId());
        securityUser.setRoles(roles.stream().map(SysRole::getRoleKey).toList());
        if (securityUser.isAdmin()) {
            securityUser.setPermissions(List.of("*:*:*"));
        } else {
            securityUser.setPermissions(menuMapper.selectPermsByUserId(user.getId()));
        }
        return securityUser;
    }
}
