package com.heaven.service;

import com.heaven.pojo.Category;
import com.heaven.pojo.vo.CategoryVO;
import com.heaven.pojo.vo.NewItemsVO;

import java.util.List;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午2:29
 */
public interface CategoryService {

    /**
     * 查询所有一级分类
     *
     * @return 分类集合
     */
    List<Category> queryAllRootLevelCat();

    /**
     * 根据父类id获取子类列表
     *
     * @param rootCatId 父类id
     * @return 分类列表
     */
    List<CategoryVO> getSubCatList(Integer rootCatId);

    /**
     * 根据父类id查询六个商品明细（商品推荐）
     *
     * @param rootCatId 父类id
     * @return 商品列表
     */
    List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId);
}
