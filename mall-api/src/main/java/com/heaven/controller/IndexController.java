package com.heaven.controller;

import com.alibaba.fastjson.JSONObject;
import com.heaven.enums.YesOrNo;
import com.heaven.pojo.Carousel;
import com.heaven.pojo.Category;
import com.heaven.service.CarouselService;
import com.heaven.service.CategoryService;
import com.heaven.utils.JsonUtils;
import com.heaven.utils.Result;
import com.heaven.vo.CarouselVO;
import com.heaven.vo.CategoryVO;
import com.heaven.vo.NewItemsVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.CollectionUtils;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午1:59
 */
@Api("首页展示的相关接口")
@RestController
@RequestMapping("/index")
public class IndexController {

    @Autowired
    private CarouselService carouselService;
    @Autowired
    private CategoryService categoryService;

    @ApiOperation(value = "获取首页轮播图列表", notes = "获取首页轮播图列表", httpMethod = "GET")
    @GetMapping("/carousel")
    public Result carousel() {
        List<Carousel> list = carouselService.queryAll(YesOrNo.YES.type);
        if (!CollectionUtils.isEmpty(list)) {
            List<CarouselVO> carouselVOS = new ArrayList<>();
            for (Carousel carousel : list) {
                CarouselVO carouselVO = JSONObject.parseObject(JSONObject.toJSONString(carousel), CarouselVO.class);
                carouselVOS.add(carouselVO);
            }
            return Result.ok(carouselVOS);
        }
        return Result.ok();
    }

    @ApiOperation(value = "获取商品分类(一级分类)", notes = "获取商品分类(一级分类)", httpMethod = "GET")
    @GetMapping("/cats")
    public Result cats() {
        List<Category> list = categoryService.queryAllRootLevelCat();
        if (!CollectionUtils.isEmpty(list)) {
            List<CategoryVO> categoryVOS = new ArrayList<>();
            for (Category category : list) {
                CategoryVO categoryVO = JSONObject.parseObject(JSONObject.toJSONString(category), CategoryVO.class);
                categoryVOS.add(categoryVO);
            }
            return Result.ok(categoryVOS);
        }
        return Result.ok();
    }

    @ApiOperation(value = "获取商品子分类", notes = "获取商品子分类", httpMethod = "GET")
    @GetMapping("/subCat/{rootCatId}")
    public Result subCat(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {

        if (ObjectUtils.isEmpty(rootCatId)) {
            return Result.errorMsg("分类不存在");
        }
        return Result.ok(categoryService.getSubCatList(rootCatId));
    }

    @ApiOperation(value = "查询每个一级分类下的最新6条商品数据(商品推荐)", notes = "查询每个一级分类下的最新6条商品数据", httpMethod = "GET")
    @GetMapping("/sixNewItems/{rootCatId}")
    public Result sixNewItems(
            @ApiParam(name = "rootCatId", value = "一级分类id", required = true)
            @PathVariable Integer rootCatId) {

        if (ObjectUtils.isEmpty(rootCatId)) {
            return Result.errorMsg("分类不存在");
        }

        return Result.ok(categoryService.getSixNewItemsLazy(rootCatId));
    }

}
