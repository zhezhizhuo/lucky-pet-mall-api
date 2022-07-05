package com.lucky.pet.collects.service;


import com.lucky.pet.common.core.domain.entity.UserCollects;
import com.lucky.pet.common.core.domain.vo.Goods;

import java.util.List;

/**
 * 用户收藏Service接口
 *
 * @author qgj
 * @date 2022-04-19
 */
public interface IUserCollectsService
{
    /**
     * 查询用户收藏
     *
     * @param colId 用户收藏主键
     * @return 用户收藏
     */
    public UserCollects selectUserCollectsByColId(Long colId);

    /**
     * 查询用户收藏列表
     *
     * @param userCollects 用户收藏
     * @return 用户收藏集合
     */
    public List<UserCollects> selectUserCollectsList(UserCollects userCollects);

    /**
     * 新增用户收藏
     *
     * @param userCollects 用户收藏
     * @return 结果
     */
    public int insertUserCollects(UserCollects userCollects);

    /**
     * 修改用户收藏
     *
     * @param userCollects 用户收藏
     * @return 结果
     */
    public int updateUserCollects(UserCollects userCollects);

    /**
     * 批量删除用户收藏
     *
     * @param colIds 需要删除的用户收藏主键集合
     * @return 结果
     */
    public int deleteUserCollectsByColIds(Long[] colIds);

    /**
     * 删除用户收藏信息
     *
     * @param colId 用户收藏主键
     * @return 结果
     */
    public int deleteUserCollectsByColId(Long colId);

    int getUserAddCollect(Long userId, Long ids);

    int getUserDelCollect(Long userId, Long ids);

    List<Goods> selectUserCollectListByUid(Long userId);
    List<Goods>  selectUserCollectListByUid(Long userId,String pid);
    int getUserDelCollectByPid(Long userId, Long id);
}
