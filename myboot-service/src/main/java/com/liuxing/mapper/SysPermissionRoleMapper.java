package com.liuxing.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.liuxing.entity.SysPermissionRole;
import org.apache.ibatis.annotations.Param;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author liuxing
 * @since 2019-09-14
 */
public interface SysPermissionRoleMapper extends BaseMapper<SysPermissionRole> {

    SysPermissionRole getRoleId(@Param("id") String id);
}
