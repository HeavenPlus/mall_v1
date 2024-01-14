package com.heaven.mapper;


import com.heaven.BaseMapper;
import com.heaven.pojo.Category;
import com.heaven.pojo.vo.CategoryVO;
import com.heaven.pojo.vo.NewItemsVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface CategoryMapper extends BaseMapper<Category> {

    /**
     * 根据父类id获取子类列表
     *
     * @param rootCatId 父类id
     * @return 分类列表
     */
    List<CategoryVO> getSubCatList(@Param("rootCatId") Integer rootCatId);

    /**
     * 根据父类id查询六个商品明细（商品推荐）
     *
     * @param rootCatId 父类id
     * @return 商品列表
     */
    List<NewItemsVO> getSixNewItemsLazy(@Param("rootCatId") Integer rootCatId);
}