package com.lucky.pet.address.service.impl;


import com.lucky.pet.address.mapper.UserAddressMapper;
import com.lucky.pet.address.service.IUserAddressService;
import com.lucky.pet.common.core.domain.entity.UserAddress;
import com.lucky.pet.common.utils.DateUtils;
import com.lucky.pet.common.utils.SecurityUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


/**
 * 地址管理Service业务层处理
 *
 * @author qgj
 * @date 2022-04-18
 */
@Service
public class UserAddressServiceImpl implements IUserAddressService
{
    @Autowired
    private UserAddressMapper userAddressMapper;

    /**
     * 查询地址管理
     *
     * @param id 地址管理主键
     * @return 地址管理
     */
    @Override
    public UserAddress selectUserAddressById(Long id)
    {
        return userAddressMapper.selectUserAddressById(id);
    }

    /**
     * 查询地址管理列表
     *
     * @param userAddress 地址管理
     * @return 地址管理
     */
    @Override
    public List<UserAddress> selectUserAddressList(UserAddress userAddress)
    {
        return userAddressMapper.selectUserAddressList(userAddress);
    }

    /**
     * 新增地址管理
     *
     * @param userAddress 地址管理
     * @return 结果
     */
    @Override
    public int insertUserAddress(UserAddress userAddress)
    {
        userAddress.setCreateTime(DateUtils.getNowDate());
        return userAddressMapper.insertUserAddress(userAddress);
    }

    /**
     * 修改地址管理
     *
     * @param userAddress 地址管理
     * @return 结果
     */
    @Override
    public int updateUserAddress(UserAddress userAddress)
    {
        userAddress.setUpdateTime(DateUtils.getNowDate());
        return userAddressMapper.updateUserAddress(userAddress);
    }

    /**
     * 批量删除地址管理
     *
     * @param ids 需要删除的地址管理主键
     * @return 结果
     */
    @Override
    public int deleteUserAddressByIds(Long[] ids)
    {
        return userAddressMapper.deleteUserAddressByIds(ids);
    }

    /**
     * 删除地址管理信息
     *
     * @param id 地址管理主键
     * @return 结果
     */
    @Override
    public int deleteUserAddressById(Long id)
    {
        return userAddressMapper.deleteUserAddressById(id);
    }

    @Transactional(rollbackFor = Exception.class)
    @Override
    public int userSetAddressDefault(String id) {
        //排他思想
        Long userId = SecurityUtils.getUserId();
        userAddressMapper.setUserAddresIsNotDefault(userId);
        //他这个用户所有的变成非默认
        userAddressMapper.updateAddressSetDefualt(id);
        //然后把传过来的 地址id 变成默认的
        return  1;
    }

    @Override
    public List<UserAddress> selectUserADdresByUser(Long userId) {
        return  userAddressMapper.selectUserADdresByUser(userId);
    }
}
