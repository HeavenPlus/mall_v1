package com.heaven.pojo.bo;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.ToString;

import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 上午10:24
 */
@ToString
@Data
@ApiModel(value = "用户登录注册对象", description = "客户端传入的数据")
public class UserBO {

    @ApiModelProperty(value = "用户名", name = "username", required = true)
    @NotBlank(message = "用户名不能为空")
    private String username;

    @ApiModelProperty(value = "密码", name = "password", required = true)
    @NotBlank(message = "密码不能为空")
    @Size(min = 6, message = "密码长度不能小于6")
    private String password;

    @ApiModelProperty(value = "确认密码", name = "confirmPassword")
    private String confirmPassword;

}
