package com.heaven.service;

import com.heaven.pojo.Carousel;

import java.util.List;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午2:07
 */
public interface CarouselService {

    /**
     * 查询轮播图
     * @param isShow 是否展示
     * @return 轮播图列表
     */
    List<Carousel> queryAll(Integer isShow);
}
