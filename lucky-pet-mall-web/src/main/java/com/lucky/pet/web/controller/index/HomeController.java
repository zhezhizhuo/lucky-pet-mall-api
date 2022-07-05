package com.lucky.pet.web.controller.index;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.lucky.pet.category.service.IProductCategoryService;
import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.home.service.IHomeBannerService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiModelProperty;
import io.swagger.annotations.ApiOperation;
import org.springframework.boot.Banner;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * @author zhiZhou
 * @createDate: 2022/6/19 18:50
 */
@RestController
@RequestMapping("/public/home")
@Api(tags = "首页模块 包括uniApp,PC端 ")
@ApiSort(1)
public class HomeController extends BaseController {


    @Resource
    private IHomeBannerService bannerService;


    @Resource
    private IProductCategoryService categoryService;



    /**
     *  首页轮播图
     * @return
     */
    @ApiOperation(value = "首页轮播图")
    @GetMapping("/carousel")
    public AjaxResult getBanner(){
        return AjaxResult.success(bannerService.getPcBanner());
    }

    /**
     * 获取九宫格图标
     */
    @ApiOperation(value = "uniapp 获取九宫格图标")
    @GetMapping("/nineHouseGrid")
    public AjaxResult getNineHouseGrid(){
        return AjaxResult.success(categoryService.selectCategoryNineHouseGridList());
    }
    /**
     * 获取分类数据
     */
    @ApiOperation(value = " uniapp获取分类数据" ,tags = "uniapp 部分")
    @GetMapping("/category")
    public AjaxResult getCategory(){

        return AjaxResult.success(categoryService.selectHomeProductCategoryList());
    }
    /**
     * 获取分类数据
     */
    @ApiOperation(value = "获取分类数据")
    @GetMapping("/top/category")
    public AjaxResult getCategoryTop(){
        return AjaxResult.success(categoryService.selectHomeProductCategoryListTop());
    }
}
