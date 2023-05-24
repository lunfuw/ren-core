package com.ren.core.handler;

import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;

import java.util.List;


/**
 * 默认授权校验类
 * @author R
 */
@Slf4j
@AllArgsConstructor
public class RenPermissionHandler implements IPermissionHandler {

    @Override
    public boolean permissionAll() {
        return false;
    }

    @Override
    public boolean hasPermission(String permission) {
        return false;
    }

    /**
     * 获取接口权限地址
     *
     * @param roleId 角色id
     * @return permissions
     */
    private List<String> permissionPath(String roleId) {
        return null;
    }

    /**
     * 获取接口权限信息
     *
     * @param permission 权限编号
     * @param roleId     角色id
     * @return permissions
     */
    private List<String> permissionCode(String permission, String roleId) {
        return null;
    }

}