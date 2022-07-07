package com.lucky.pet.web.controller.user;

import com.github.xiaoymin.knife4j.annotations.ApiSort;
import com.lucky.pet.address.service.IUserAddressService;
import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.common.core.domain.entity.UserAddress;
import com.lucky.pet.common.utils.DateUtils;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.web.bind.annotation.*;

import javax.annotation.Resource;
import java.util.Date;

/**
 * 地址管理Controller
 *
 * @author qgj
 * @date 2022-04-18
 */
@RestController
@Api(tags = "地址模块")
@ApiSort(8)
@RequestMapping("/user/address")
public class UserAddressController extends BaseController {
    @Resource
    private IUserAddressService userAddressService;

    /**
     * 添加收获地址
     * @param userAddress
     * @return
     */
    @PostMapping("/userAdd/address")
    @ApiOperation(value = "添加收获地址",tags = "用户地址")
    public AjaxResult getUserAddAddress(@RequestBody UserAddress userAddress){
        userAddress.setUid(getUserId());
        Date now = DateUtils.getNowDate();
        userAddress.setCreateTime(now);
        userAddress.setUpdateTime(now);
        return  AjaxResult.success(userAddressService.insertUserAddress(userAddress));
    }

    /**
     * 删除收获地址
     * @param id
     * @return
     */
    @GetMapping("/address/del")
    @ApiOperation(value = "删除收获地址",tags = "用户地址")
    public AjaxResult getUserDelAddress(    @ApiParam("地址id") Long id){
        return  AjaxResult.success(userAddressService.deleteUserAddressById(id));
    }

    /**
     * 查询收获地址
     * @return
     */
    @GetMapping("/address")
    @ApiOperation(value = "获取收获地址",tags = "用户地址")
    public AjaxResult getUserSelectAddress(){
        return  AjaxResult.success(userAddressService.selectUserADdresByUser(getUserId()));
    }

    /**
     * 修改收获地址
     * @param userAddress
     * @return
     */
    @PostMapping("/address/update")
    @ApiOperation(value = "修改收获地址",tags = "用户地址")
    public AjaxResult getUserUpadteAddress(@RequestBody UserAddress userAddress){
        return  AjaxResult.success(userAddressService.updateUserAddress(userAddress));
    }

    /**
     *     //设为默认值地址
     * @param id
     * @return
     */
    @GetMapping("/address/setDefault")
    @ApiOperation(value = "设为默认值地址",tags = "用户地址")
    public AjaxResult getUserDefalutAddress(@RequestParam   @ApiParam("地址id") String id){

        return  AjaxResult.success(userAddressService.userSetAddressDefault(id));
    }
}
