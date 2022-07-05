package com.lucky.pet.collects.service.impl;

import com.lucky.pet.collects.mapper.UserCollectsMapper;
import com.lucky.pet.collects.service.IUserCollectsService;
import com.lucky.pet.common.core.domain.entity.UserCollects;
import com.lucky.pet.common.core.domain.vo.Goods;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * 用户收藏Service业务层处理
 *
 * @author qgj
 * @date 2022-04-19
 */
@Service
public class UserCollectsServiceImpl implements IUserCollectsService {
    @Autowired
    private UserCollectsMapper userCollectsMapper;

    /**
     * 查询用户收藏
     *
     * @param colId 用户收藏主键
     * @return 用户收藏
     */
    @Override
    public UserCollects selectUserCollectsByColId(Long colId) {
        return userCollectsMapper.selectUserCollectsByColId(colId);
    }

    /**
     * 查询用户收藏列表
     *
     * @param userCollects 用户收藏
     * @return 用户收藏
     */
    @Override
    public List<UserCollects> selectUserCollectsList(UserCollects userCollects) {
        return userCollectsMapper.selectUserCollectsList(userCollects);
    }

    /**
     * 新增用户收藏
     *
     * @param userCollects 用户收藏
     * @return 结果
     */
    @Override
    public int insertUserCollects(UserCollects userCollects) {
        return userCollectsMapper.insertUserCollects(userCollects);
    }

    /**
     * 修改用户收藏
     *
     * @param userCollects 用户收藏
     * @return 结果
     */
    @Override
    public int updateUserCollects(UserCollects userCollects) {
        return userCollectsMapper.updateUserCollects(userCollects);
    }

    /**
     * 批量删除用户收藏
     *
     * @param colIds 需要删除的用户收藏主键
     * @return 结果
     */
    @Override
    public int deleteUserCollectsByColIds(Long[] colIds) {
        return userCollectsMapper.deleteUserCollectsByColIds(colIds);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public int getUserAddCollect(Long userId, Long id) {
        System.out.println(id);
        UserCollects user = new UserCollects();
        user.setUserId(userId);
        user.setPid(id);
        user.setAddTime(new Date());
        user.setCreateTime(new Date());
        user.setIsDelete(0L);
        //查看是否已经添加

        return userCollectsMapper.insertUserCollects(user);
    }

    @Override
    public int getUserDelCollect(Long userId, Long id) {
        UserCollects user = new UserCollects();
        user.setUserId(userId);
        user.setPid(id);
        return userCollectsMapper.updateUserCollectsByPid(user);
    }

    @Override
    public int getUserDelCollectByPid(Long userId, Long id) {
        UserCollects user = new UserCollects();
        user.setPid(id);
        user.setIsDelete(1L);
        return userCollectsMapper.updateUserCollectsByPid(user);
    }

    @Override
    public List<Goods> selectUserCollectListByUid(Long userId) {
        return userCollectsMapper.selectUserCollectListByUid(userId);
    }

    @Override
    public List<Goods> selectUserCollectListByUid(Long userId, String pid) {
        return userCollectsMapper.selectUserCollectListByUidandPid(userId, pid);
    }

    /**
     * 删除用户收藏信息
     *
     * @param colId 用户收藏主键
     * @return 结果
     */
    @Override
    public int deleteUserCollectsByColId(Long colId) {
        return userCollectsMapper.deleteUserCollectsByColId(colId);
    }
}
