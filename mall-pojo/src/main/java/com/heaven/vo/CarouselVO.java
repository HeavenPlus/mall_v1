package com.heaven.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午2:02
 */
@ToString
@Data
@ApiModel(value = "轮播图对象", description = "返回给客户端的数据")
public class CarouselVO {

    @ApiModelProperty(value = "主键")
    private String id;
    @ApiModelProperty(value = "图片地址")
    private String imageUrl;
    @ApiModelProperty(value = "背景色")
    private String backgroundColor;
    @ApiModelProperty(value = "商品id")
    private String itemId;
    @ApiModelProperty(value = "商品分类id")
    private String catId;
    @ApiModelProperty(value = "轮播图类型")
    private Integer type;
    @ApiModelProperty(value = "轮播图展示顺序")
    private Integer sort;
    @ApiModelProperty(value = "是否展示")
    private Integer isShow;
    @ApiModelProperty(value = "创建时间")
    private Date createTime;
    @ApiModelProperty(value = "更新时间")
    private Date updateTime;
}
