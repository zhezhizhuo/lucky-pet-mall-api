package com.lucky.pet.cart.service.impl;

import com.lucky.pet.cart.mapper.OrderCartMapper;
import com.lucky.pet.cart.service.IOrderCartService;
import com.lucky.pet.common.core.domain.entity.OrderCart;
import com.lucky.pet.common.core.domain.entity.ProductInfo;
import com.lucky.pet.common.core.domain.model.UserCardBody;
import com.lucky.pet.common.core.domain.vo.UserCartOv;
import com.lucky.pet.common.exception.ServiceException;
import com.lucky.pet.common.utils.SecurityUtils;
import com.lucky.pet.product.service.IProductInfoService;
import com.lucky.pet.product.service.impl.ProductInfoServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import javax.annotation.Resource;
import java.util.Date;
import java.util.List;

/**
 * 用户购物车Service业务层处理
 *
 * @author qgj
 * @date 2022-04-23
 */
@Service
public class OrderCartServiceImpl implements IOrderCartService
{
    @Autowired
    private OrderCartMapper orderCartMapper;

    @Resource
    private IProductInfoService productService;
    /**
     * 查询用户购物车
     *
     * @param id 用户购物车主键
     * @return 用户购物车
     */
    @Override
    public OrderCart selectOrderCartById(Long id)
    {
        return orderCartMapper.selectOrderCartById(id);
    }

    /**
     * 查询用户购物车列表
     *
     * @param orderCart 用户购物车
     * @return 用户购物车
     */
    @Override
    public List<OrderCart> selectOrderCartList(OrderCart orderCart)
    {
        return orderCartMapper.selectOrderCartList(orderCart);
    }

    /**
     * 新增用户购物车
     *
     * @param orderCart 用户购物车
     * @return 结果
     */
    @Override
    public int insertOrderCart(OrderCart orderCart)
    {
        return orderCartMapper.insertOrderCart(orderCart);
    }

    /**
     * 修改用户购物车
     *
     * @param orderCart 用户购物车
     * @return 结果
     */
    @Override
    public int updateOrderCart(OrderCart orderCart)
    {
        return orderCartMapper.updateOrderCart(orderCart);
    }

    /**
     * 批量删除用户购物车
     *
     * @param ids 需要删除的用户购物车主键
     * @return 结果
     */
    @Override
    public int deleteOrderCartByIds(Long[] ids)
    {
        return orderCartMapper.deleteOrderCartByIds(ids);
    }

    /**
     * 删除用户购物车信息
     *
     * @param id 用户购物车主键
     * @return 结果
     */
    @Override
    public int deleteOrderCartById(Long id)
    {
        return orderCartMapper.deleteOrderCartById(id);
    }

    @Override
    public List<UserCartOv> selectCarByUserId(Long userId) {
        return orderCartMapper.selectCarByUserId(userId);
    }
    @Override
    public int UserAddCart(UserCardBody userCard) {
        Long userId = SecurityUtils.getUserId();
        //查看商品是否存在
        ProductInfo product =null;
        try {
            product = productService.selectProductByProductId(Long.valueOf(userCard.getId()));

        }   catch (NullPointerException e){
            throw  new ServiceException("该商品不存在");
        }
        if (product ==null){
             return  -1;
        }else {
            OrderCart cart = new OrderCart();
            cart.setpId(product.getProductId());
            cart.setCount(Long.valueOf(userCard.getCount()));
            cart.setuId(userId);
            cart.setPrice(product.getPrice());
            cart.setAddTime(new Date());
            cart.setIsDelete(0L);
            return orderCartMapper.insertOrderCart(cart);
        }
    }

    @Override
    public int updateUserCarDel(List<Long> carIds) {
        return orderCartMapper.updateUserCarDel(carIds);
    }

    @Transactional
    @Override
    public int UserAddCartList(List<UserCardBody> userCards) {
        Long userId = SecurityUtils.getUserId();
        for (UserCardBody userCard : userCards) {
            //查看商品是否存在
            ProductInfo product =null;
            try {
                product = productService.selectProductByProductId(Long.valueOf(userCard.getId()));
            }   catch (NullPointerException e){
                throw  new ServiceException("该商品不存在");
            }
            if (product ==null){
                return  -1;
            }else {
                OrderCart cart = new OrderCart();
                cart.setpId(product.getProductId());
                cart.setCount(Long.valueOf(userCard.getCount()));
                cart.setuId(userId);
                cart.setPrice(product.getPrice());
                cart.setAddTime(new Date());
                cart.setIsDelete(0L);
             orderCartMapper.insertOrderCart(cart);
            }
        }
        return 1;
    }

    @Override
    public int selectUserCartCount(Long userId) {
        return orderCartMapper.selectUserCartCount(userId);
    }
}
