package com.heaven.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午10:23
 */
@ToString
@Data
@ApiModel(value = "购物车对象", description = "返回给客户端的数据")
public class ShopCarVO {

    @ApiModelProperty(value = "商品id")
    private String itemId;
    @ApiModelProperty(value = "商品图片地址")
    private String itemImgUrl;
    @ApiModelProperty(value = "商品名称")
    private String itemName;
    @ApiModelProperty(value = "规格id")
    private String specId;
    @ApiModelProperty(value = "规格名称")
    private String specName;
    @ApiModelProperty(value = "折扣价")
    private String priceDiscount;
    @ApiModelProperty(value = "原价")
    private String priceNormal;
}
