package com.lucky.pet.collects.mapper;

import com.lucky.pet.common.core.domain.entity.UserCollects;
import com.lucky.pet.common.core.domain.vo.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户收藏Mapper接口
 *
 * @author qgj
 * @date 2022-04-19
 */

public interface UserCollectsMapper
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
     * 删除用户收藏
     *
     * @param colId 用户收藏主键
     * @return 结果
     */
    public int deleteUserCollectsByColId(Long colId);

    /**
     * 批量删除用户收藏
     *
     * @param colIds 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteUserCollectsByColIds(Long[] colIds);

    List<Goods> selectUserCollectListByUid(Long userId);

    int updateUserCollectsByPid(UserCollects user);

    List<Goods> selectUserCollectListByUidandPid(@Param("userId")Long userId, @Param("pid") String pid);
}
