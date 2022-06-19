package com.lucky.pet.web.controller.index;

import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.home.service.IHomeBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhiZhou
 * @createDate: 2022/6/19 18:50
 */
@RestController()
@RequestMapping("/public/home")
@Api(tags = "首页模块 PC端")
public class HomeController extends BaseController {


    @Resource
    private IHomeBannerService bannerService;

    /**
     *  首页轮播图
     * @return
     */
    @ApiModelProperty("首页轮播图")
    @GetMapping("/carousel")
    public AjaxResult getBanner(){
        return AjaxResult.success(bannerService.getPcBanner());
    }
}
