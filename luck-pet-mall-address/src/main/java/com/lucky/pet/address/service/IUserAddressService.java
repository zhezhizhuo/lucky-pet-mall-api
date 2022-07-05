package com.lucky.pet.address.service;


import com.lucky.pet.common.core.domain.entity.UserAddress;

import java.util.List;

/**
 * 地址管理Service接口
 *
 * @author qgj
 * @date 2022-04-18
 */
public interface IUserAddressService
{
    /**
     * 查询地址管理
     *
     * @param id 地址管理主键
     * @return 地址管理
     */
    public UserAddress selectUserAddressById(Long id);

    /**
     * 查询地址管理列表
     *
     * @param userAddress 地址管理
     * @return 地址管理集合
     */
    public List<UserAddress> selectUserAddressList(UserAddress userAddress);

    /**
     * 新增地址管理
     *
     * @param userAddress 地址管理
     * @return 结果
     */
    public int insertUserAddress(UserAddress userAddress);

    /**
     * 修改地址管理
     *
     * @param userAddress 地址管理
     * @return 结果
     */
    public int updateUserAddress(UserAddress userAddress);

    /**
     * 批量删除地址管理
     *
     * @param ids 需要删除的地址管理主键集合
     * @return 结果
     */
    public int deleteUserAddressByIds(Long[] ids);

    /**
     * 删除地址管理信息
     *
     * @param id 地址管理主键
     * @return 结果
     */
    public int deleteUserAddressById(Long id);

    int userSetAddressDefault(String id);

    List<UserAddress> selectUserADdresByUser(Long userId);
}
