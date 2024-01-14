package com.heaven.service;

import com.heaven.pojo.Items;
import com.heaven.pojo.ItemsImg;
import com.heaven.pojo.ItemsParam;
import com.heaven.pojo.ItemsSpec;
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
}
