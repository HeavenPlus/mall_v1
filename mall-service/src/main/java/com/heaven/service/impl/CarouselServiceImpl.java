package com.heaven.service.impl;

import com.heaven.mapper.CarouselMapper;
import com.heaven.pojo.Carousel;
import com.heaven.service.CarouselService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午2:07
 */
@Service
public class CarouselServiceImpl implements CarouselService {

    @Autowired
    private CarouselMapper carouselMapper;

    /**
     * 查询轮播图
     *
     * @param isShow 是否展示
     * @return 轮播图列表
     */
    @Override
    public List<Carousel> queryAll(Integer isShow) {
        Example carouselExample = new Example(Carousel.class);
        carouselExample.orderBy("sort").desc();
        Example.Criteria criteria = carouselExample.createCriteria();
        criteria.andEqualTo("isShow", isShow);
        return carouselMapper.selectByExample(carouselExample);
    }
}
