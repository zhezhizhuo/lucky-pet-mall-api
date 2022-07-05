package com.lucky.pet.product.mapper;

import com.lucky.pet.common.core.domain.entity.ProductComment;
import com.lucky.pet.common.core.domain.vo.CommentOv;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * 评论表 用户评论Mapper接口
 *
 * @author qgj
 * @date 2022-04-21
 */

public interface ProductCommentMapper
{
    /**
     * 查询评论表 用户评论
     *
     * @param comId 评论表 用户评论主键
     * @return 评论表 用户评论
     */
    public ProductComment selectProductCommentByComId(Long comId);

    /**
     * 查询评论表 用户评论列表
     *
     * @param productComment 评论表 用户评论
     * @return 评论表 用户评论集合
     */
    public List<ProductComment> selectProductCommentList(ProductComment productComment);

    /**
     * 新增评论表 用户评论
     *
     * @param productComment 评论表 用户评论
     * @return 结果
     */
    public int insertProductComment(ProductComment productComment);

    /**
     * 修改评论表 用户评论
     *
     * @param productComment 评论表 用户评论
     * @return 结果
     */
    public int updateProductComment(ProductComment productComment);

    /**
     * 删除评论表 用户评论
     *
     * @param comId 评论表 用户评论主键
     * @return 结果
     */
    public int deleteProductCommentByComId(Long comId);

    /**
     * 批量删除评论表 用户评论
     *
     * @param comIds 需要删除的数据主键集合
     * @return 结果
     */
    int deleteProductCommentByComIds(Long[] comIds);

    List<CommentOv> selectProductCommentByPid(Long id);

    int userIpComment(Long id);

    int selectCommByUIdAndComId(@Param("uid") Long userId, @Param("cid") Integer commid);

    int userSubComment(Long id);

    List<CommentOv> selectProductCommentByPidHot(Long id);
}
