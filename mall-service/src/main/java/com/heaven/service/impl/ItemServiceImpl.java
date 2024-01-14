package com.heaven.service.impl;

import com.github.pagehelper.PageHelper;
import com.heaven.enums.CommentLevel;
import com.heaven.mapper.*;
import com.heaven.pojo.*;
import com.heaven.pojo.vo.CommentLevelCountsVO;
import com.heaven.pojo.vo.ItemCommentVO;
import com.heaven.pojo.vo.SearchItemsVO;
import com.heaven.pojo.vo.ShopCarVO;
import com.heaven.service.ItemService;
import com.heaven.utils.DesensitizationUtil;
import com.heaven.utils.PageResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午4:32
 */
@Service
public class ItemServiceImpl implements ItemService {

    @Autowired
    private ItemsMapper itemsMapper;
    @Autowired
    private ItemsImgMapper itemsImgMapper;
    @Autowired
    private ItemsSpecMapper itemsSpecMapper;
    @Autowired
    private ItemsParamMapper itemsParamMapper;
    @Autowired
    private ItemsCommentsMapper itemsCommentsMapper;

    /**
     * 查询商品详情
     *
     * @param itemId 商品id
     * @return 商品信息
     */
    @Override
    public Items queryItemById(String itemId) {
        return itemsMapper.selectByPrimaryKey(itemId);
    }

    /**
     * 查询商品图片
     *
     * @param itemId 商品id
     * @return 商品图片
     */
    @Override
    public List<ItemsImg> queryItemImgList(String itemId) {
        Example itemImgExample = new Example(ItemsImg.class);
        Example.Criteria criteria = itemImgExample.createCriteria();
        criteria.andEqualTo("itemId", itemId);
        return itemsImgMapper.selectByExample(itemImgExample);
    }

    /**
     * 查询商品规格
     *
     * @param itemId 商品id
     * @return 商品规格
     */
    @Override
    public List<ItemsSpec> queryItemSpecList(String itemId) {
        Example itemSpecExample = new Example(ItemsSpec.class);
        Example.Criteria criteria = itemSpecExample.createCriteria();
        criteria.andEqualTo("itemId", itemId);
        return itemsSpecMapper.selectByExample(itemSpecExample);
    }

    /**
     * 查询商品参数
     *
     * @param itemId 商品id
     * @return 商品参数
     */
    @Override
    public ItemsParam queryItemParam(String itemId) {
        Example itemParamExample = new Example(ItemsParam.class);
        Example.Criteria criteria = itemParamExample.createCriteria();
        criteria.andEqualTo("itemId", itemId);
        return itemsParamMapper.selectOneByExample(itemParamExample);
    }

    /**
     * 查询商品评价等级及数量
     *
     * @param itemId 商品id
     * @return 商品评价等级及数量
     */
    @Override
    public CommentLevelCountsVO queryCommentCounts(String itemId) {
        Integer goodCounts = getCommentCounts(itemId, CommentLevel.GOOD.type);
        Integer normalCounts = getCommentCounts(itemId, CommentLevel.NORMAL.type);
        Integer badCounts = getCommentCounts(itemId, CommentLevel.BAD.type);
        Integer totalCounts = goodCounts + normalCounts + badCounts;

        CommentLevelCountsVO countsVO = new CommentLevelCountsVO();
        countsVO.setTotalCounts(totalCounts);
        countsVO.setGoodCounts(goodCounts);
        countsVO.setNormalCounts(normalCounts);
        countsVO.setBadCounts(badCounts);

        return countsVO;
    }

    /**
     * 查询商品评价
     *
     * @param itemId   商品id
     * @param level    等级
     * @param page     页数
     * @param pageSize 条数
     * @return 商品评价
     */
    @Override
    public PageResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("itemId", itemId);
        paramMap.put("level", level);

        PageHelper.startPage(page, pageSize);

        List<ItemCommentVO> list = itemsMapper.queryItemComments(paramMap);
        for (ItemCommentVO vo : list) {
            vo.setNickname(DesensitizationUtil.commonDisplay(vo.getNickname()));
        }
        return new PageResult(list, page);
    }

    /**
     * 根据关键字搜索商品
     *
     * @param keywords 关键字
     * @param sort     排序规则
     * @param page     页数
     * @param pageSize 条数
     * @return 商品列表
     */
    @Override
    public PageResult searchItems(String keywords, String sort, Integer page, Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("keywords", keywords);
        paramMap.put("sort", sort);

        PageHelper.startPage(page, pageSize);
        List<SearchItemsVO> list = itemsMapper.searchItems(paramMap);

        return new PageResult(list, page);
    }

    /**
     * 根据分类id查询商品
     *
     * @param catId    分类id
     * @param sort     排序规则
     * @param page     页数
     * @param pageSize 条数
     * @return 商品列表
     */
    @Override
    public PageResult searchItems(Integer catId, String sort, Integer page, Integer pageSize) {
        Map<String, Object> paramMap = new HashMap<>();
        paramMap.put("catId", catId);
        paramMap.put("sort", sort);

        PageHelper.startPage(page, pageSize);
        List<SearchItemsVO> list = itemsMapper.searchItemsByCatId(paramMap);

        return new PageResult(list, page);
    }

    /**
     * 根据商品规格查询商品信息
     *
     * @param itemSpecIds 商品规格ids
     * @return 商品信息
     */
    @Override
    public List<ShopCarVO> queryItemsBySpecIds(String itemSpecIds) {
        String ids[] = itemSpecIds.split(",");
        List<String> specIdsList = new ArrayList<>();
        Collections.addAll(specIdsList, ids);
        return itemsMapper.queryItemsBySpecIds(specIdsList);
    }


    private Integer getCommentCounts(String itemId, Integer level) {
        ItemsComments condition = new ItemsComments();
        condition.setItemId(itemId);
        if (level != null) {
            condition.setCommentLevel(level);
        }
        return itemsCommentsMapper.selectCount(condition);
    }
}
