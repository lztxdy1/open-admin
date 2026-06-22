package com.openadmin.system.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.openadmin.system.domain.SysRole;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Select;
import java.util.List;

@Mapper
public interface SysRoleMapper extends BaseMapper<SysRole> {
    @Select("select r.* from sys_role r inner join sys_user_role ur on r.id = ur.role_id where ur.user_id = #{userId} and r.status = 1")
    List<SysRole> selectRolesByUserId(Long userId);
}
