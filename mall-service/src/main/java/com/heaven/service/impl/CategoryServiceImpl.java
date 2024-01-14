package com.heaven.service.impl;

import com.heaven.mapper.CategoryMapper;
import com.heaven.pojo.Category;
import com.heaven.service.CategoryService;
import com.heaven.pojo.vo.CategoryVO;
import com.heaven.pojo.vo.NewItemsVO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午2:31
 */
@Service
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryMapper categoryMapper;

    /**
     * 查询所有一级分类
     *
     * @return 分类集合
     */
    @Override
    public List<Category> queryAllRootLevelCat() {
        Example categoryExample = new Example(Category.class);
        Example.Criteria criteria = categoryExample.createCriteria();
        criteria.andEqualTo("type", 1);
        return categoryMapper.selectByExample(categoryExample);
    }

    /**
     * 根据父类id获取子类列表
     *
     * @param rootCatId 父类id
     * @return 分类列表
     */
    @Override
    public List<CategoryVO> getSubCatList(Integer rootCatId) {
        return categoryMapper.getSubCatList(rootCatId);
    }

    /**
     * 根据父类id查询六个商品明细（商品推荐）
     *
     * @param rootCatId 父类id
     * @return 商品列表
     */
    @Override
    public List<NewItemsVO> getSixNewItemsLazy(Integer rootCatId) {
        return categoryMapper.getSixNewItemsLazy(rootCatId);
    }
}
