package com.heaven.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午9:47
 */
@ToString
@Data
@ApiModel(value = "商品搜索对象", description = "返回给客户端的数据")
public class SearchItemsVO {

    @ApiModelProperty(value = "商品id")
    private String itemId;
    @ApiModelProperty(value = "商品名称")
    private String itemName;
    @ApiModelProperty(value = "销量")
    private int sellCounts;
    @ApiModelProperty(value = "图片地址")
    private String imgUrl;
    @ApiModelProperty(value = "价格")
    private int price;
}
