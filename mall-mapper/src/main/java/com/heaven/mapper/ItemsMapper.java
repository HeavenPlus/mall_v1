package com.heaven.mapper;


import com.heaven.BaseMapper;
import com.heaven.pojo.Items;
import com.heaven.pojo.vo.ItemCommentVO;
import com.heaven.pojo.vo.SearchItemsVO;
import com.heaven.pojo.vo.ShopCarVO;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ItemsMapper extends BaseMapper<Items> {

    /**
     * 查询商品评价
     *
     * @param paramMap 查询参数
     * @return 商品评价
     */
    List<ItemCommentVO> queryItemComments(@Param("paramMap") Map<String, Object> paramMap);

    /**
     * 根据关键字搜索商品
     *
     * @param paramMap 查询参数
     * @return 商品信息
     */
    List<SearchItemsVO> searchItems(@Param("paramMap") Map<String, Object> paramMap);

    /**
     * 根据分类id搜索商品
     *
     * @param paramMap 查询参数
     * @return 商品信息
     */
    List<SearchItemsVO> searchItemsByCatId(@Param("paramMap") Map<String, Object> paramMap);

    /**
     * 根据规格ids查询商品
     *
     * @param specIdsList 规格ids
     * @return 商品信息
     */
    List<ShopCarVO> queryItemsBySpecIds(@Param("specIdsList") List<String> specIdsList);
}