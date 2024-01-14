package com.heaven.service;

import com.heaven.pojo.bo.UserBO;
import com.heaven.pojo.Users;
import com.heaven.pojo.vo.UserVO;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/13 下午11:02
 */
public interface UserService {

    /**
     * 查询用户名是否存在
     *
     * @param username 用户名
     * @return 用户名是否存在
     */
    Boolean queryUsernameIsExist(String username);

    /**
     * 创建用户
     * @param userBO 入参
     * @return 出参
     */
    UserVO createUser(UserBO userBO);

    /**
     * 根据用户名密码查询用户信息
     * @param username 用户名
     * @param md5Str md5后的密码
     * @return 用户信息
     */
    Users queryUserForLogin(String username, String md5Str);
}
