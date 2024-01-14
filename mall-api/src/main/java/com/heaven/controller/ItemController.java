package com.heaven.controller;

import com.heaven.pojo.Items;
import com.heaven.pojo.ItemsImg;
import com.heaven.pojo.ItemsParam;
import com.heaven.pojo.ItemsSpec;
import com.heaven.pojo.vo.CommentLevelCountsVO;
import com.heaven.pojo.vo.ItemInfoVO;
import com.heaven.service.ItemService;
import com.heaven.utils.Result;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.util.ObjectUtils;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午4:24
 */
@Api(tags = "商品相关接口")
@RestController
@RequestMapping("/items")
public class ItemController {

    @Autowired
    private ItemService itemService;

    public static final Integer COMMON_PAGE_SIZE = 10;
    public static final Integer PAGE_SIZE = 20;

    @ApiOperation(value = "查询商品详情", notes = "查询商品详情", httpMethod = "GET")
    @GetMapping("/info/{itemId}")
    public Result info(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @PathVariable String itemId) {

        if (StringUtils.isBlank(itemId)) {
            return Result.errorMsg(null);
        }

        //商品信息
        Items item = itemService.queryItemById(itemId);
        //商品图片
        List<ItemsImg> itemImgList = itemService.queryItemImgList(itemId);
        //商品规格
        List<ItemsSpec> itemsSpecList = itemService.queryItemSpecList(itemId);
        //商品参数
        ItemsParam itemsParam = itemService.queryItemParam(itemId);

        ItemInfoVO itemInfoVO = new ItemInfoVO();
        itemInfoVO.setItem(item);
        itemInfoVO.setItemImgList(itemImgList);
        itemInfoVO.setItemSpecList(itemsSpecList);
        itemInfoVO.setItemParams(itemsParam);

        return Result.ok(itemInfoVO);
    }

    @ApiOperation(value = "查询商品评价等级和数量", notes = "查询商品评价等级和数量", httpMethod = "GET")
    @GetMapping("/commentLevel")
    public Result commentLevel(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @RequestParam String itemId) {

        if (StringUtils.isBlank(itemId)) {
            return Result.errorMsg(null);
        }

        CommentLevelCountsVO countsVO = itemService.queryCommentCounts(itemId);

        return Result.ok(countsVO);
    }

    @ApiOperation(value = "查询商品评论", notes = "查询商品评论", httpMethod = "GET")
    @GetMapping("/comments")
    public Result comments(
            @ApiParam(name = "itemId", value = "商品id", required = true)
            @RequestParam String itemId,
            @ApiParam(name = "level", value = "评价等级")
            @RequestParam Integer level,
            @ApiParam(name = "page", value = "页数")
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "条数")
            @RequestParam Integer pageSize) {

        if (StringUtils.isBlank(itemId)) {
            return Result.errorMsg(null);
        }

        if (ObjectUtils.isEmpty(page)) {
            page = 1;
        }

        if (ObjectUtils.isEmpty(pageSize)) {
            pageSize = COMMON_PAGE_SIZE;
        }
        return Result.ok(itemService.queryPagedComments(itemId, level, page, pageSize));
    }

    @ApiOperation(value = "搜索商品列表", notes = "搜索商品列表", httpMethod = "GET")
    @GetMapping("/search")
    public Result search(
            @ApiParam(name = "keywords", value = "关键字", required = true)
            @RequestParam String keywords,
            @ApiParam(name = "sort", value = "排序")
            @RequestParam String sort,
            @ApiParam(name = "page", value = "页数")
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "条数")
            @RequestParam Integer pageSize) {

        if (StringUtils.isBlank(keywords)) {
            return Result.errorMsg(null);
        }

        if (ObjectUtils.isEmpty(page)) {
            page = 1;
        }

        if (ObjectUtils.isEmpty(pageSize)) {
            pageSize = PAGE_SIZE;
        }

        return Result.ok(itemService.searchItems(keywords, sort, page, pageSize));
    }

    @ApiOperation(value = "通过分类id搜索商品列表", notes = "通过分类id搜索商品列表", httpMethod = "GET")
    @GetMapping("/catItems")
    public Result catItems(
            @ApiParam(name = "catId", value = "三级分类id", required = true)
            @RequestParam Integer catId,
            @ApiParam(name = "sort", value = "排序")
            @RequestParam String sort,
            @ApiParam(name = "page", value = "页数")
            @RequestParam Integer page,
            @ApiParam(name = "pageSize", value = "条数")
            @RequestParam Integer pageSize) {

        if (ObjectUtils.isEmpty(catId)) {
            return Result.errorMsg(null);
        }

        if (ObjectUtils.isEmpty(page)) {
            page = 1;
        }

        if (ObjectUtils.isEmpty(pageSize)) {
            pageSize = PAGE_SIZE;
        }

        return Result.ok(itemService.searchItems(catId, sort, page, pageSize));
    }

    @ApiOperation(value = "根据商品规格ids查找最新的商品数据", notes = "根据商品规格ids查找最新的商品数据", httpMethod = "GET")
    @GetMapping("/refresh")
    public Result refresh(
            @ApiParam(name = "itemSpecIds", value = "拼接的规格ids", required = true, example = "1001,1003,1005")
            @RequestParam String itemSpecIds) {

        if (StringUtils.isBlank(itemSpecIds)) {
            return Result.ok();
        }

        return Result.ok(itemService.queryItemsBySpecIds(itemSpecIds));
    }
}
