package com.liuxing.service;

import com.baomidou.mybatisplus.extension.service.IService;
import com.liuxing.entity.SysPermissionRole;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author liuxing
 * @since 2019-09-14
 */
public interface SysPermissionRoleService extends IService<SysPermissionRole> {

    SysPermissionRole getRoleId(String id);
}
