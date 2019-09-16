package com.liuxing.controller.login;

import com.liuxing.common.jwt.JwtUtils;
import com.liuxing.controller.base.BaseController;
import com.liuxing.entity.User;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/loginPage")
@Api(value = "登录模块")
public class LoginController extends BaseController {

    private Logger logger= LoggerFactory.getLogger(LoginController.class);

    @Autowired
    private JwtUtils jwtUtils;

    @RequestMapping(value = "/login",method = RequestMethod.POST)
    @ResponseBody
    @ApiOperation(value = "用户登陆")
    public String login(@RequestBody User user){
        String s = jwtUtils.generateToken(user.getUserId());
        return s;
    }
}
