package com.lucky.pet.cart.mapper;

import com.lucky.pet.common.core.domain.entity.OrderCart;
import com.lucky.pet.common.core.domain.vo.UserCartOv;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户购物车Mapper接口
 *
 * @author qgj
 * @date 2022-04-23
 */

public interface OrderCartMapper
{
    /**
     * 查询用户购物车
     *
     * @param id 用户购物车主键
     * @return 用户购物车
     */
    public OrderCart selectOrderCartById(Long id);

    /**
     * 查询用户购物车列表
     *
     * @param orderCart 用户购物车
     * @return 用户购物车集合
     */
    public List<OrderCart> selectOrderCartList(OrderCart orderCart);

    /**
     * 新增用户购物车
     *
     * @param orderCart 用户购物车
     * @return 结果
     */
    public int insertOrderCart(OrderCart orderCart);

    /**
     * 修改用户购物车
     *
     * @param orderCart 用户购物车
     * @return 结果
     */
    public int updateOrderCart(OrderCart orderCart);

    /**
     * 删除用户购物车
     *
     * @param id 用户购物车主键
     * @return 结果
     */
    public int deleteOrderCartById(Long id);

    /**
     * 批量删除用户购物车
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteOrderCartByIds(Long[] ids);

    List<UserCartOv> selectCarByUserId(Long userId);

    int selectUserCartCount(Long userId);

    int updateUserCarDel(@Param("list") List<Long> carIds);
}
