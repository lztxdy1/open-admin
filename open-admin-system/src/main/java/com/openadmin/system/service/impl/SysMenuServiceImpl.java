package com.openadmin.system.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.LambdaQueryWrapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.openadmin.system.domain.SysMenu;
import com.openadmin.system.mapper.SysMenuMapper;
import com.openadmin.system.service.SysMenuService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SysMenuServiceImpl extends ServiceImpl<SysMenuMapper, SysMenu> implements SysMenuService {
    @Override
    public List<SysMenu> selectRoutes(Long userId, boolean admin) {
        if (admin) {
            return list(new LambdaQueryWrapper<SysMenu>().eq(SysMenu::getStatus, 1).orderByAsc(SysMenu::getSort));
        }
        return baseMapper.selectMenusByUserId(userId);
    }
}
