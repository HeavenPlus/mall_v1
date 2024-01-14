package com.heaven.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午5:08
 */
@ToString
@Data
@ApiModel(value = "商品评价等级及数量对象", description = "返回给客户端的数据")
public class CommentLevelCountsVO {

    @ApiModelProperty(value = "总数")
    public Integer totalCounts;
    @ApiModelProperty(value = "好评数")
    public Integer goodCounts;
    @ApiModelProperty(value = "中评数")
    public Integer normalCounts;
    @ApiModelProperty(value = "差评数")
    public Integer badCounts;
}
