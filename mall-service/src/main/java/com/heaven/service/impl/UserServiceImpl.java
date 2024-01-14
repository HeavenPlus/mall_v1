package com.heaven.service.impl;

import com.alibaba.fastjson.JSONObject;
import com.heaven.pojo.bo.UserBO;
import com.heaven.enums.Sex;
import com.heaven.mapper.UsersMapper;
import com.heaven.pojo.Users;
import com.heaven.service.UserService;
import com.heaven.utils.DateUtil;
import com.heaven.utils.MD5Utils;
import com.heaven.pojo.vo.UserVO;
import org.n3r.idworker.Sid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.ObjectUtils;
import tk.mybatis.mapper.entity.Example;

import java.util.Date;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/13 下午11:07
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UsersMapper usersMapper;
    @Autowired
    private Sid sid;

    private static final String USER_FACE = "http://122.152.205.72:88/group1/M00/00/05/CpoxxFw_8_qAIlFXAAAcIhVPdSg994.png";

    /**
     * 查询用户名是否存在
     *
     * @param username 用户名
     * @return 用户名是否存在
     */
    @Override
    public Boolean queryUsernameIsExist(String username) {
        Example userExample = new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username", username);
        Users users = usersMapper.selectOneByExample(userExample);
        return !ObjectUtils.isEmpty(users);
    }

    /**
     * 创建用户
     *
     * @param userBO 入参
     * @return 出参
     */
    @Override
    public UserVO createUser(UserBO userBO) {
        String userId = sid.nextShort();
        Users user = new Users();
        user.setId(userId);
        user.setUsername(userBO.getUsername());
        try {
            user.setPassword(MD5Utils.getMD5Str(userBO.getPassword()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        // 默认用户昵称同用户名
        user.setNickname(userBO.getUsername());
        // 默认头像
        user.setFace(USER_FACE);
        // 默认生日
        user.setBirthday(DateUtil.stringToDate("1900-01-01"));
        // 默认性别为 保密
        user.setSex(Sex.SECRET.type);
        user.setCreatedTime(new Date());
        user.setUpdatedTime(new Date());

        usersMapper.insert(user);
        return JSONObject.parseObject(JSONObject.toJSONString(user), UserVO.class);
    }

    /**
     * 根据用户名密码查询用户信息
     *
     * @param username 用户名
     * @param md5Str   md5后的密码
     * @return 用户信息
     */
    @Override
    public Users queryUserForLogin(String username, String md5Str) {
        Example userExample = new Example(Users.class);
        Example.Criteria criteria = userExample.createCriteria();
        criteria.andEqualTo("username", username);
        criteria.andEqualTo("password", md5Str);
        return usersMapper.selectOneByExample(userExample);
    }
}
