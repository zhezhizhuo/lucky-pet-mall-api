package com.lucky.pet.product.service.impl;

import com.lucky.pet.common.core.domain.entity.CommentPost;
import com.lucky.pet.common.utils.DateUtils;
import com.lucky.pet.product.mapper.CommentPostMapper;
import com.lucky.pet.product.service.ICommentPostService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.List;

/**
 * 用户点赞记录Service业务层处理
 *
 * @author qgj
 * @date 2022-04-24
 */
@Service
public class CommentPostServiceImpl implements ICommentPostService
{
    @Resource
    private CommentPostMapper commentPostMapper;

    /**
     * 查询用户点赞记录
     *
     * @param id 用户点赞记录主键
     * @return 用户点赞记录
     */
    @Override
    public CommentPost selectCommentPostById(Long id)
    {
        return commentPostMapper.selectCommentPostById(id);
    }

    /**
     * 查询用户点赞记录列表
     *
     * @param commentPost 用户点赞记录
     * @return 用户点赞记录
     */
    @Override
    public List<CommentPost> selectCommentPostList(CommentPost commentPost)
    {
        return commentPostMapper.selectCommentPostList(commentPost);
    }

    /**
     * 新增用户点赞记录
     *
     * @param commentPost 用户点赞记录
     * @return 结果
     */
    @Override
    public int insertCommentPost(CommentPost commentPost)
    {
        commentPost.setCreateTime(DateUtils.getNowDate());
        return commentPostMapper.insertCommentPost(commentPost);
    }

    /**
     * 修改用户点赞记录
     *
     * @param commentPost 用户点赞记录
     * @return 结果
     */
    @Override
    public int updateCommentPost(CommentPost commentPost)
    {
        return commentPostMapper.updateCommentPost(commentPost);
    }

    /**
     * 批量删除用户点赞记录
     *
     * @param ids 需要删除的用户点赞记录主键
     * @return 结果
     */
    @Override
    public int deleteCommentPostByIds(Long[] ids)
    {
        return commentPostMapper.deleteCommentPostByIds(ids);
    }

    /**
     * 删除用户点赞记录信息
     *
     * @param id 用户点赞记录主键
     * @return 结果
     */
    @Override
    public int deleteCommentPostById(Long id)
    {
        return commentPostMapper.deleteCommentPostById(id);
    }

    @Override
    public int deleteCommentUser(Long id, Long userId) {
        return commentPostMapper.deleteCommentUser(id,userId);
    }
}
