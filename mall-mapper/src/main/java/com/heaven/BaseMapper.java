package com.heaven;

import tk.mybatis.mapper.common.Mapper;
import tk.mybatis.mapper.common.MySqlMapper;

/**
 * @Description
 * @Author Heaven
 * @Date 2023/12/10 下午8:39
 */
public interface BaseMapper<T> extends Mapper<T>, MySqlMapper<T> {
}