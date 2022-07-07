package com.lucky.pet.web.controller.cart;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.lucky.pet.cart.service.IOrderCartService;
import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.common.core.domain.model.UserCardBody;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * @author zhiZhou
 * @createDate: 2022/7/7 18:24
 */
@RestController
@Api(tags = "用户购物车模块")
@ApiSort(7)
@RequestMapping("/cart")
public class OrderCartController extends BaseController {
    @Resource
    private IOrderCartService orderCartService;

    @GetMapping
    @ApiOperation("获取购物车列表")
    public AjaxResult getUserCartList(){

        return AjaxResult.success(orderCartService.selectCarByUserId(getUserId()));
    }

    @DeleteMapping("/cart/{ids}")
    @ApiOperation("删除/清空购物车商品")
    public AjaxResult  getUserDeleteCart(@PathVariable Long[] ids){
        return toAjax(orderCartService.deleteOrderCartByIds(ids));
    }


    //加入购物车
    @PostMapping()
    @ApiOperation("加入购物车")
    public AjaxResult  getUserCartAdd(@RequestBody UserCardBody card){
        int isSuccess = orderCartService.UserAddCart( card);
        if (isSuccess == -1){
            return  AjaxResult.error("商品不存在");
        }
        return toAjax(isSuccess);
    }


    //合并购物车
    @PostMapping("merge")
    @ApiOperation("合并购物车")
    public AjaxResult  getUserCartMerge(@RequestBody List<UserCardBody> userCards){
        int isSuccess = orderCartService.UserAddCartList( userCards);
        if (isSuccess == -1){
            return  AjaxResult.error("商品不存在");
        }
        return toAjax(isSuccess);
    }

    @GetMapping("/count")
    @ApiOperation("获取购物车数量")
    public AjaxResult  getUserCartCount(){
        Map<String, Integer> count = new HashMap<>();
        count.put("count",orderCartService.selectUserCartCount(getUserId()));
        AjaxResult result =AjaxResult.success(count);
        return result;
    }
}
