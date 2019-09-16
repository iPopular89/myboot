package com.liuxing.controller.sys;


import com.liuxing.entity.SysPermissionRole;
import com.liuxing.service.SysPermissionRoleService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

/**
 * <p>
 *  前端控制器
 * </p>
 *
 * @author liuxing
 * @since 2019-09-14
 */
@Controller
@RequestMapping("/sysRole")
@Api(value = "系统角色模块")
public class SysPermissionRoleController {

    private Logger logger= LoggerFactory.getLogger(SysPermissionRole.class);

    @Autowired
    private SysPermissionRoleService sysPermissionRoleService;

    @ApiOperation(value = "获取用户信息")
    @RequestMapping(value = "/getInfo",method = RequestMethod.POST)
    @ResponseBody
    public String getInfo(@ApiParam(value="id") @RequestParam(value="id") String pid){
        logger.info("sdsdsd,{},{}","22","333");
        SysPermissionRole list = sysPermissionRoleService.getRoleId(pid);
        return list.toString();
    }

    @ApiOperation(value = "获取用户信息列表")
    @RequestMapping(value = "/getList",method = RequestMethod.POST)
    @ResponseBody
    public String getList(){
        logger.info("sdsdsd,{},{}","22","333");
        List<SysPermissionRole> list = sysPermissionRoleService.list();
        return list.toString();
    }

    @ApiOperation(value = "新增用户")
    @RequestMapping(value = "/addInfo",method = RequestMethod.POST)
    @ResponseBody
    public String addInfo(SysPermissionRole sysPermissionRole){
        logger.info("新增用户");
        boolean save = sysPermissionRoleService.save(sysPermissionRole);
        if(save){
            return "success";
        }else{
            return "false";
        }
    }
}

