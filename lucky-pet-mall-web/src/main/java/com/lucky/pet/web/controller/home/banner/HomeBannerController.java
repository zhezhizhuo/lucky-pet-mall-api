package com.lucky.pet.web.controller.home.banner;

import java.util.List;
import javax.annotation.Resource;
import javax.servlet.http.HttpServletResponse;

import com.github.xiaoymin.knife4j.annotations.ApiOperationSupport;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.lucky.pet.common.annotation.Log;
import com.lucky.pet.common.core.controller.BaseController;
import com.lucky.pet.common.core.domain.AjaxResult;
import com.lucky.pet.common.enums.BusinessType;
import com.lucky.pet.common.core.domain.entity.HomeBanner;
import com.lucky.pet.home.service.IHomeBannerService;
import com.lucky.pet.common.utils.poi.ExcelUtil;
import com.lucky.pet.common.core.page.TableDataInfo;

/**
 * 轮播图片Controller
 *
 * @author qgj
 * @date 2022-06-16
 */
@RestController
@Api( tags = "轮播图片接口")
@RequestMapping("/home/banner")
public class HomeBannerController extends BaseController {
    @Resource
    private IHomeBannerService homeBannerService;

    /**
     * 查询轮播图片列表
     */
    @ApiOperation(value = "查询轮播图片列表")
    @PreAuthorize("@ss.hasPermi('home:home:list')")
    @GetMapping("/list")
    public TableDataInfo list(HomeBanner homeBanner) {
        startPage();
        List<HomeBanner> list = homeBannerService.selectHomeBannerList(homeBanner);
        return getDataTable(list);
    }

    /**
     * 导出轮播图片列表
     */
    @ApiOperation(value = "导出轮播图片列表")
    @PreAuthorize("@ss.hasPermi('home:home:export')")
    @Log(title = "轮播图片", businessType = BusinessType.EXPORT)
    @PostMapping("/export")
    public void export(HttpServletResponse response, HomeBanner homeBanner) {
        List<HomeBanner> list = homeBannerService.selectHomeBannerList(homeBanner);
        ExcelUtil<HomeBanner> util = new ExcelUtil<HomeBanner>(HomeBanner. class);
        util.exportExcel(response, list, "轮播图片数据");
    }

    /**
     * 获取轮播图片详细信息
     */
    @ApiOperation(value = "获取轮播图片详细信息")
    @PreAuthorize("@ss.hasPermi('home:home:query')")
    @GetMapping(value = "/{id}")
    public AjaxResult getInfo(@PathVariable("id") Long id) {
        return AjaxResult.success(homeBannerService.selectHomeBannerById(id));
    }

    /**
     * 新增轮播图片
     */
    @ApiOperation(value = "新增轮播图片")
    @PreAuthorize("@ss.hasPermi('home:home:add')")
    @Log(title = "轮播图片", businessType = BusinessType.INSERT)
    @PostMapping
    public AjaxResult add(@RequestBody HomeBanner homeBanner) {
        return toAjax(homeBannerService.insertHomeBanner(homeBanner));
    }

    /**
     * 修改轮播图片
     */
    @ApiOperation(value = "修改轮播图片")
    @PreAuthorize("@ss.hasPermi('home:home:edit')")
    @Log(title = "轮播图片", businessType = BusinessType.UPDATE)
    @PutMapping
    public AjaxResult edit(@RequestBody HomeBanner homeBanner) {
        return toAjax(homeBannerService.updateHomeBanner(homeBanner));
    }

    /**
     * 删除轮播图片
     */
    @ApiOperation(value = "删除轮播图片")
    @PreAuthorize("@ss.hasPermi('home:home:remove')")
    @Log(title = "轮播图片", businessType = BusinessType.DELETE)
    @DeleteMapping("/{ids}")
    public AjaxResult remove(@PathVariable Long[] ids) {
        return toAjax(homeBannerService.deleteHomeBannerByIds(ids));
    }
}
