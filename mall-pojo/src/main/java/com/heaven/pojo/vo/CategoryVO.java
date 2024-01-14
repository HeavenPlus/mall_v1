package com.heaven.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午2:23
 */
@ToString
@Data
@ApiModel(value = "一级分类对象", description = "返回给客户端的数据")
public class CategoryVO {
    @ApiModelProperty(value = "主键")
    private Integer id;
    @ApiModelProperty(value = "分类名称")
    private String name;
    @ApiModelProperty(value = "分类类型")
    private Integer type;
    @ApiModelProperty(value = "父id")
    private Integer fatherId;
    @ApiModelProperty(value = "图标")
    private String logo;
    @ApiModelProperty(value = "口号")
    private String slogan;
    @ApiModelProperty(value = "分类图")
    private String catImage;
    @ApiModelProperty(value = "背景颜色")
    private String bgColor;
    @ApiModelProperty(value = "子类列表")
    private List<SubCategoryVO> subCatList;
}
