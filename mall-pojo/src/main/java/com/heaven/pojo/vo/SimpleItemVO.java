package com.heaven.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午3:38
 */
@ToString
@Data
@ApiModel(value = "子类商品信息对象", description = "返回给客户端的数据")
public class SimpleItemVO {

    @ApiModelProperty(value = "商品id")
    private String itemId;
    @ApiModelProperty(value = "商品名称")
    private String itemName;
    @ApiModelProperty(value = "图片地址")
    private String itemUrl;
}
