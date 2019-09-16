package com.liuxing.service.impl;

import com.liuxing.entity.SysPermissionRole;
import com.liuxing.mapper.SysPermissionRoleMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.liuxing.service.SysPermissionRoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * <p>
 *  服务实现类
 * </p>
 *
 * @author liuxing
 * @since 2019-09-14
 */
@Service("sysPermissionRoleService")
public class SysPermissionRoleServiceImpl extends ServiceImpl<SysPermissionRoleMapper, SysPermissionRole> implements SysPermissionRoleService {

    @Autowired
    private SysPermissionRoleMapper sysPermissionRoleMapper;

    @Override
    public SysPermissionRole getRoleId(String id) {
        return sysPermissionRoleMapper.getRoleId(id);
    }
}
