package com.heaven.pojo.vo;

import com.heaven.pojo.Items;
import com.heaven.pojo.ItemsImg;
import com.heaven.pojo.ItemsParam;
import com.heaven.pojo.ItemsSpec;
import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import java.util.List;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午4:26
 */
@ToString
@Data
@ApiModel(value = "商品详情对象", description = "返回给客户端的数据")
public class ItemInfoVO {

    @ApiModelProperty(value = "商品信息")
    private Items item;
    @ApiModelProperty(value = "商品图片")
    private List<ItemsImg> itemImgList;
    @ApiModelProperty(value = "商品规格")
    private List<ItemsSpec> itemSpecList;
    @ApiModelProperty(value = "商品参数")
    private ItemsParam itemParams;

}
