package com.lucky.pet.web.controller.register;

import com.github.xiaoymin.knife4j.annotations.ApiSort;

import com.lucky.pet.common.constant.Constants;
import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.common.core.domain.entity.SysUser;
import com.lucky.pet.common.core.domain.vo.RegisterOv;
import com.lucky.pet.common.core.redis.RedisCache;
import com.lucky.pet.common.utils.MessageUtils;
import com.lucky.pet.common.utils.SecurityUtils;
import com.lucky.pet.common.utils.StringUtils;
import com.lucky.pet.framework.manager.AsyncManager;
import com.lucky.pet.framework.manager.factory.AsyncFactory;
import com.lucky.pet.system.service.ISysUserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import javax.validation.Valid;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.TimeUnit;

@RestController
@Api(tags = "注册模块")
@ApiSort(3)
@RequestMapping("/public/register")
public class UserRegisterController extends BaseController {


    @Resource
    private ISysUserService sysUserService;

//    @Resource
//    private MessageCode messageCode;

    @Resource
    private RedisCache redisCache;

    @PostMapping
    @ApiOperation("用户注册")
    public AjaxResult UserRegister(@Valid @RequestBody(required = true) RegisterOv register) {

        /**
         *  验证手机验证码
         */
        //寻找这个key
//        String key = redisCache.getCacheObject(register.getUuid());
//        if (StringUtils.isEmpty(key)){
//            return  AjaxResult.error("验证码不存在或已失效");
//        }
//        //拿到key里面的值 和用户输入的code 是否一致
//        if (!StringUtils.equals(key,register.getCode())){
//            return  AjaxResult.error("验证码错误");
//        }
        /**
         * 开始注册
         */

        SysUser sysUser = new SysUser();
        sysUser.setUserName(register.getUsername());
        sysUser.setNickName(register.getNick_name());
        //注册到sys表里面
        sysUser.setSex(String.valueOf(register.getSex()));
        //电话
        sysUser.setPhonenumber(register.getMobile());
        SysUser user = sysUserService.checkUserPhone(register.getMobile());
        if (user != null) {
            return AjaxResult.error("手机号码已存在,注册失败");
        }
        sysUser.setPassword(SecurityUtils.encryptPassword(register.getPassword()));
        //设置默认头像
        sysUser.setAvatar("https://i.gtimg.cn/club/item/face/img/2/15922_100.gif");
        boolean regFlag = sysUserService.registerUser(sysUser);
        String msg ="注册成功";
        if (!regFlag)
        {
            msg = "注册失败,请联系系统管理人员";
        }
        else
        {
            AsyncManager.me().execute(AsyncFactory.recordLogininfor(sysUser.getUserName(), Constants.REGISTER,
                    MessageUtils.message("user.register.success")));
        }
        AjaxResult result = AjaxResult.success(msg);

        return result;
    }

    /**
     *  验证手机验证码 //根据电话还没发送验证码
     */

//
//    @GetMapping("/code")
//    @ApiOperation(value = "注册-验证手机验证码", notes = "返回uuid  唯一表示 每一个验证码都不一样")
//    public AjaxResult sendMobilCode(@RequestParam String mobile) {
//        //生成key
//        String key = Constants.MOBILE + mobile;
//
////        发送验证码需要时间 让另外线程处理
//        new Thread(() -> {
//            //发送验证码
//            MessageBean messageBean = messageCode.sendMail(mobile);
//            if (messageBean.getCode() == 200) {       //判断是否发送成功
//                //2.  存储 在 session 里面
//
//                logger.error("手机的验证码是 ==>  " + messageBean.getObj());
//                logger.error("发送手机验证码成功");
//            } else {
//                //发送失败
//                logger.error("发送验证码失败 原因是==>  {}" + messageBean.getObj() + messageBean.getMsg());
//                throw new ServiceException("发送验证码失败");
//            }
//            //存入redis
//            redisCache.setCacheObject(key, messageBean.getObj(), 3, TimeUnit.MINUTES);
//        }).start();
////                    redisCache.setCacheObject(key, "123123", 3, TimeUnit.MINUTES);
//
//        Map<String, String> map = new HashMap<>();
//        map.put("uuid", key);
//        //把key 返回前端
//        return AjaxResult.success(map);
//    }
//
//
//    //校验用户名
//    @GetMapping("/check")
//    @ApiOperation("注册-校验用户名唯一")
//    public AjaxResult UserCheckName(@RequestParam String account) {
//        String isCheck = sysUserService.checkUserNameUnique(account);
//        if (isCheck == "1") {
//            return AjaxResult.success(true);
//        }
//        return AjaxResult.success(false);
//    }

    /**
     *     //校验电话唯一
     * @param mobile
     * @return
     */
    @GetMapping("/check/mobile")
    @ApiOperation("注册-校验电话唯一")
    public AjaxResult UserCheckMobile(@RequestParam String mobile) {
        SysUser sysUser = sysUserService.checkUserPhone(mobile);
        if (sysUser == null) {
            return AjaxResult.success(false);
        }
        return AjaxResult.success(true);
    }





}
