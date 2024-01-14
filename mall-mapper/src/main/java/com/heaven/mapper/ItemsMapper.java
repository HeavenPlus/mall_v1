package com.heaven.mapper;


import com.heaven.BaseMapper;
import com.heaven.pojo.Items;
import com.heaven.pojo.vo.ItemCommentVO;
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
}