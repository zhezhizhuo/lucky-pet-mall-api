package com.lucky.pet.web.controller.login;

import com.lucky.pet.common.constant.Constants;
import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.common.core.domain.entity.SysUser;
import com.lucky.pet.common.core.domain.model.LoginBody;
import com.lucky.pet.common.core.domain.vo.RegisterOv;
import com.lucky.pet.common.core.redis.RedisCache;
import com.lucky.pet.common.utils.MessageUtils;
import com.lucky.pet.common.utils.SecurityUtils;
import com.lucky.pet.common.utils.StringUtils;
import com.lucky.pet.framework.manager.AsyncManager;
import com.lucky.pet.framework.manager.factory.AsyncFactory;
import com.lucky.pet.framework.web.service.SysLoginService;
import com.lucky.pet.system.service.ISysUserService;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import com.github.xiaoymin.knife4j.annotations.ApiSort;

import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * PC用户登录
 * @author zhizhuo
 */
@RestController
@Api(tags = "用户登录")
@ApiSort(2)
@RequestMapping("/public")
public class LoginController extends BaseController {

    @Autowired
    private SysLoginService loginService;



    @Resource
    private ISysUserService userService;

    @Resource
    private RedisCache redisCache;

    @PostMapping("/login")
    @ApiOperation("Pc 用户登录 ")
    public AjaxResult login(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword(),loginBody.getCode(),loginBody.getUuid());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

    @PostMapping("/login/uniapp")
    @ApiOperation("uniapp 用户登录 ")
    @ApiOperationSupport(includeParameters = {"username", "password"}, ignoreParameters = {"uuid", "code"})
    public AjaxResult UniappLogin(@RequestBody LoginBody loginBody) {
        AjaxResult ajax = AjaxResult.success();
        // 生成令牌
        String token = loginService.login(loginBody.getUsername(), loginBody.getPassword());
        ajax.put(Constants.TOKEN, token);
        return ajax;
    }

}
