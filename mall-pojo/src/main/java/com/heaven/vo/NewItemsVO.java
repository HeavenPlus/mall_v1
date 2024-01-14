package com.heaven.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午3:36
 */
@ToString
@Data
@ApiModel(value = "商品信息对象", description = "返回给客户端的数据")
public class NewItemsVO {

    @ApiModelProperty(value = "父级id")
    private Integer rootCatId;
    @ApiModelProperty(value = "父级名称")
    private String rootCatName;
    @ApiModelProperty(value = "口号")
    private String slogan;
    @ApiModelProperty(value = "图片")
    private String catImage;
    @ApiModelProperty(value = "背景色")
    private String bgColor;

    @ApiModelProperty(value = "子类商品列表")
    private List<SimpleItemVO> simpleItemList;
}
