package com.liuxing.entity;

import com.baomidou.mybatisplus.extension.activerecord.Model;
import java.io.Serializable;

/**
 * <p>
 * 
 * </p>
 *
 * @author liuxing
 * @since 2019-09-14
 */
public class SysPermissionRole extends Model<SysPermissionRole> {

    private static final long serialVersionUID=1L;

    private String permissionId;

    private String roleId;


    public String getPermissionId() {
        return permissionId;
    }

    public void setPermissionId(String permissionId) {
        this.permissionId = permissionId;
    }

    public String getRoleId() {
        return roleId;
    }

    public void setRoleId(String roleId) {
        this.roleId = roleId;
    }

    @Override
    protected Serializable pkVal() {
        return this.permissionId;
    }

    @Override
    public String toString() {
        return "SysPermissionRole{" +
        "permissionId=" + permissionId +
        ", roleId=" + roleId +
        "}";
    }
}
