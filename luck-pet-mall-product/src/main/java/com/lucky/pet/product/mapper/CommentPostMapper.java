package com.lucky.pet.product.mapper;

import com.lucky.pet.common.core.domain.entity.CommentPost;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 用户点赞记录Mapper接口
 *
 * @author qgj
 * @date 2022-04-24
 */

public interface CommentPostMapper
{
    /**
     * 查询用户点赞记录
     *
     * @param id 用户点赞记录主键
     * @return 用户点赞记录
     */
    public CommentPost selectCommentPostById(Long id);

    /**
     * 查询用户点赞记录列表
     *
     * @param commentPost 用户点赞记录
     * @return 用户点赞记录集合
     */
    public List<CommentPost> selectCommentPostList(CommentPost commentPost);

    /**
     * 新增用户点赞记录
     *
     * @param commentPost 用户点赞记录
     * @return 结果
     */
    public int insertCommentPost(CommentPost commentPost);

    /**
     * 修改用户点赞记录
     *
     * @param commentPost 用户点赞记录
     * @return 结果
     */
    public int updateCommentPost(CommentPost commentPost);

    /**
     * 删除用户点赞记录
     *
     * @param id 用户点赞记录主键
     * @return 结果
     */
    public int deleteCommentPostById(Long id);

    /**
     * 批量删除用户点赞记录
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteCommentPostByIds(Long[] ids);

    int deleteCommentUser(@Param("comid") Long id,@Param("uid") Long userId);
}
