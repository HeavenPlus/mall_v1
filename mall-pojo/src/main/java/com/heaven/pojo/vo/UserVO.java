package com.heaven.pojo.vo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 上午10:37
 */
@ToString
@Data
@ApiModel(value = "用户对象", description = "返回给客户端的数据")
public class UserVO {

    @ApiModelProperty(value = "用户id")
    private String id;
    @ApiModelProperty(value = "用户名")
    private String username;
    @ApiModelProperty(value = "昵称")
    private String nickname;
    @ApiModelProperty(value = "真实姓名")
    private String realname;
    @ApiModelProperty(value = "头像")
    private String face;
    @ApiModelProperty(value = "手机号")
    private String mobile;
    @ApiModelProperty(value = "性别")
    private Integer sex;


}
