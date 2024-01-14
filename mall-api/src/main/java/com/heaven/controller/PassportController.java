package com.heaven.controller;

import com.alibaba.fastjson.JSONObject;
import com.heaven.bo.UserBO;
import com.heaven.pojo.Users;
import com.heaven.service.UserService;
import com.heaven.utils.CookieUtils;
import com.heaven.utils.MD5Utils;
import com.heaven.utils.Result;
import com.heaven.vo.UserVO;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/13 下午10:53
 */
@Api(tags = "登录注册接口")
@RestController
@RequestMapping("/passport")
public class PassportController {

    @Autowired
    private UserService userService;

    @ApiOperation(value = "用户名是否存在", notes = "用户名是否存在", httpMethod = "GET")
    @GetMapping("/usernameIsExist")
    public Result usernameIsExist(@RequestParam @ApiParam(value = "用户名",required = true) String username) {
        if (StringUtils.isBlank(username)) {
            return Result.errorMsg("用户名不能为空");
        }
        Boolean res = userService.queryUsernameIsExist(username);
        if (res) {
           return Result.errorMsg("用户名已存在");
        }
        return Result.ok();
    }

    @ApiOperation(value = "注册", notes = "注册", httpMethod = "POST")
    @PostMapping("/regist")
    public Result regist(@Validated @RequestBody UserBO userBO,
                         HttpServletRequest request,
                         HttpServletResponse response) {

        if (StringUtils.isBlank(userBO.getConfirmPassword())) {
            return Result.errorMsg("请输入确认密码");
        }
        if (!userBO.getConfirmPassword().equals(userBO.getPassword())) {
            return Result.errorMsg("两次输入密码不一致");
        }
        Boolean isExist = userService.queryUsernameIsExist(userBO.getUsername());
        if (isExist) {
            return Result.errorMsg("用户名已存在");
        }
        UserVO userVO = userService.createUser(userBO);

        CookieUtils.setCookie(request, response,"user", JSONObject.toJSONString(userVO), true);

        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据

        return Result.ok();
    }

    @ApiOperation(value = "登录", notes = "登录", httpMethod = "POST")
    @PostMapping("/login")
    public Result login(@Validated @RequestBody UserBO userBO,
                         HttpServletRequest request,
                         HttpServletResponse response) throws Exception {
        Users userResult = userService.queryUserForLogin(userBO.getUsername(),
                MD5Utils.getMD5Str(userBO.getPassword()));

        if (ObjectUtils.isEmpty(userResult)) {
            return Result.errorMsg("用户不存在");
        }
        UserVO userVO = JSONObject.parseObject(JSONObject.toJSONString(userResult), UserVO.class);
        CookieUtils.setCookie(request, response,"user", JSONObject.toJSONString(userVO), true);
        // TODO 生成用户token，存入redis会话
        // TODO 同步购物车数据
        return Result.ok();
    }

    @ApiOperation(value = "退出登录", notes = "退出登录", httpMethod = "POST")
    @PostMapping("/logout")
    public Result logout(@RequestParam @ApiParam("用户id") String userId,
                        HttpServletRequest request,
                        HttpServletResponse response) throws Exception {

        // 清除用户的相关信息的cookie
        CookieUtils.deleteCookie(request, response, "user");

        // TODO 用户退出登录，需要清空购物车
        // TODO 分布式会话中需要清除用户数据
        return Result.ok();
    }
}
