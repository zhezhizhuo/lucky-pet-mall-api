package com.lucky.pet.home.mapper;
import java.util.List;
import com.lucky.pet.common.core.domain.entity.HomeBanner;

/**
 * 轮播图片Mapper接口
 *
 * @author qgj
 * @date 2022-06-16
 */

public interface HomeBannerMapper
{
    /**
     * 查询轮播图片
     *
     * @param id 轮播图片主键
     * @return 轮播图片
     */
    public HomeBanner selectHomeBannerById(Long id);

    /**
     * 查询轮播图片列表
     *
     * @param homeBanner 轮播图片
     * @return 轮播图片集合
     */
    public List<HomeBanner> selectHomeBannerList(HomeBanner homeBanner);

    /**
     * 新增轮播图片
     *
     * @param homeBanner 轮播图片
     * @return 结果
     */
    public int insertHomeBanner(HomeBanner homeBanner);

    /**
     * 修改轮播图片
     *
     * @param homeBanner 轮播图片
     * @return 结果
     */
    public int updateHomeBanner(HomeBanner homeBanner);

    /**
     * 删除轮播图片
     *
     * @param id 轮播图片主键
     * @return 结果
     */
    public int deleteHomeBannerById(Long id);

    /**
     * 批量删除轮播图片
     *
     * @param ids 需要删除的数据主键集合
     * @return 结果
     */
    public int deleteHomeBannerByIds(Long[] ids);
}
