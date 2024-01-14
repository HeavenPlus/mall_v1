package com.heaven.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.Date;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午5:28
 */
@ToString
@Data
@ApiModel(value = "商品评价对象", description = "返回给客户端的数据")
public class ItemCommentVO {

    @ApiModelProperty(value = "评价等级")
    private Integer commentLevel;
    @ApiModelProperty(value = "评价内容")
    private String content;
    @ApiModelProperty(value = "商品规格名称")
    private String specName;
    @ApiModelProperty(value = "评价时间")
    private Date createdTime;
    @ApiModelProperty(value = "用户头像")
    private String userFace;
    @ApiModelProperty(value = "用户昵称")
    private String nickname;
}
