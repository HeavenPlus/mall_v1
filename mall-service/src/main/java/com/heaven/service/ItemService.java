package com.heaven.service;

import com.heaven.pojo.Items;
import com.heaven.pojo.ItemsImg;
import com.heaven.pojo.ItemsParam;
import com.heaven.pojo.ItemsSpec;
import com.heaven.pojo.vo.ShopCarVO;
import com.heaven.utils.PageResult;
import com.heaven.pojo.vo.CommentLevelCountsVO;

import java.util.List;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午4:30
 */
public interface ItemService {

    /**
     * 查询商品详情
     *
     * @param itemId 商品id
     * @return 商品信息
     */
    Items queryItemById(String itemId);

    /**
     * 查询商品图片
     *
     * @param itemId 商品id
     * @return 商品图片
     */
    List<ItemsImg> queryItemImgList(String itemId);

    /**
     * 查询商品规格
     *
     * @param itemId 商品id
     * @return 商品规格
     */
    List<ItemsSpec> queryItemSpecList(String itemId);

    /**
     * 查询商品参数
     *
     * @param itemId 商品id
     * @return 商品参数
     */
    ItemsParam queryItemParam(String itemId);

    /**
     * 查询商品评价等级及数量
     *
     * @param itemId 商品id
     * @return 商品评价等级及数量
     */
    CommentLevelCountsVO queryCommentCounts(String itemId);

    /**
     * 查询商品评价
     *
     * @param itemId 商品id
     * @param level 等级
     * @param page 页数
     * @param pageSize 条数
     * @return 商品评价
     */
    PageResult queryPagedComments(String itemId, Integer level, Integer page, Integer pageSize);

    /**
     * 根据关键字搜索商品
     *
     * @param keywords 关键字
     * @param sort 排序规则
     * @param page 页数
     * @param pageSize 条数
     * @return 商品列表
     */
    PageResult searchItems(String keywords, String sort, Integer page, Integer pageSize);

    /**
     * 根据分类id搜索商品
     *
     * @param catId 分类id
     * @param sort 排序规则
     * @param page 页数
     * @param pageSize 条数
     * @return 商品列表
     */
    PageResult searchItems(Integer catId, String sort, Integer page, Integer pageSize);

    /**
     * 根据商品规格查询商品信息
     *
     * @param itemSpecIds 商品规格ids
     * @return 商品信息
     */
    List<ShopCarVO> queryItemsBySpecIds(String itemSpecIds);
}
