package com.heaven.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午2:50
 */
@ToString
@Data
@ApiModel(value = "子分类对象", description = "返回给客户端的数据")
public class SubCategoryVO {

    @ApiModelProperty(value = "子类id")
    private Integer subId;
    @ApiModelProperty(value = "子类名称")
    private String subName;
    @ApiModelProperty(value = "子类类型")
    private String subType;
    @ApiModelProperty(value = "父级id")
    private Integer subFatherId;
}
