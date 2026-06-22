package com.openadmin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.openadmin.system.domain.SysMenu;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface SysMenuMapper extends BaseMapper<SysMenu> {
    @Select("select distinct m.perms from sys_menu m inner join sys_role_menu rm on m.id = rm.menu_id inner join sys_user_role ur on rm.role_id = ur.role_id where ur.user_id = #{userId} and m.perms is not null and m.perms <> ''")
    List<String> selectPermsByUserId(Long userId);

    @Select("select distinct m.* from sys_menu m inner join sys_role_menu rm on m.id = rm.menu_id inner join sys_user_role ur on rm.role_id = ur.role_id where ur.user_id = #{userId} and m.status = 1 order by m.sort asc")
    List<SysMenu> selectMenusByUserId(Long userId);
}
