package com.lucky.pet.home.service.impl;

import java.util.List;

import com.lucky.pet.common.core.domain.vo.IndexCountOV;
import com.lucky.pet.common.core.domain.vo.PcBanner;
import com.lucky.pet.common.utils.DateUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.lucky.pet.home.mapper.HomeBannerMapper;
import com.lucky.pet.common.core.domain.entity.HomeBanner;
import com.lucky.pet.home.service.IHomeBannerService;

/**
 * 轮播图片Service业务层处理
 *
 * @author qgj
 * @date 2022-06-16
 */
@Service
public class HomeBannerServiceImpl implements IHomeBannerService
{
    @Autowired
    private HomeBannerMapper homeBannerMapper;

    @Override
    public IndexCountOV getIndexHomeData() {
        return this.homeBannerMapper.getIndexHomeData();
    }

    /**
     * 查询轮播图片
     *
     * @param id 轮播图片主键
     * @return 轮播图片
     */
    @Override
    public HomeBanner selectHomeBannerById(Long id)
    {
        return homeBannerMapper.selectHomeBannerById(id);
    }

    /**
     * 查询轮播图片列表
     *
     * @param homeBanner 轮播图片
     * @return 轮播图片
     */
    @Override
    public List<HomeBanner> selectHomeBannerList(HomeBanner homeBanner)
    {
        return homeBannerMapper.selectHomeBannerList(homeBanner);
    }

    /**
     * 新增轮播图片
     *
     * @param homeBanner 轮播图片
     * @return 结果
     */
    @Override
    public int insertHomeBanner(HomeBanner homeBanner)
    {
        homeBanner.setCreateTime(DateUtils.getNowDate());
        return homeBannerMapper.insertHomeBanner(homeBanner);
    }

    /**
     * 修改轮播图片
     *
     * @param homeBanner 轮播图片
     * @return 结果
     */
    @Override
    public int updateHomeBanner(HomeBanner homeBanner)
    {
        homeBanner.setUpdateTime(DateUtils.getNowDate());
        return homeBannerMapper.updateHomeBanner(homeBanner);
    }

    /**
     * 批量删除轮播图片
     *
     * @param ids 需要删除的轮播图片主键
     * @return 结果
     */
    @Override
    public int deleteHomeBannerByIds(Long[] ids)
    {
        return homeBannerMapper.deleteHomeBannerByIds(ids);
    }

    /**
     * 删除轮播图片信息
     *
     * @param id 轮播图片主键
     * @return 结果
     */
    @Override
    public int deleteHomeBannerById(Long id)
    {
        return homeBannerMapper.deleteHomeBannerById(id);
    }

    @Override
    public List<PcBanner> getPcBanner() {
        return homeBannerMapper.getBanner();
    }
}
