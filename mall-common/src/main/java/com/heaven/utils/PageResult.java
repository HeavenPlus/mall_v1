package com.heaven.utils;

import com.github.pagehelper.PageInfo;

import java.util.List;

/**
 * @Description
 * @Author Heaven
 * @Date 2024/1/14 下午5:25
 */
public class PageResult {

    private int page;            // 当前页数
    private int total;            // 总页数
    private long records;        // 总记录数
    private List<?> rows;        // 每行显示的内容

    public PageResult() {

    }

    public PageResult(List<?> rows, Integer page) {
        PageInfo<?> pageInfo = new PageInfo<>(rows);
        this.page = page;
        this.total = pageInfo.getPages();
        this.records = pageInfo.getTotal();
        this.rows = rows;
    }

    public int getPage() {
        return page;
    }

    public void setPage(int page) {
        this.page = page;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    public long getRecords() {
        return records;
    }

    public void setRecords(long records) {
        this.records = records;
    }

    public List<?> getRows() {
        return rows;
    }

    public void setRows(List<?> rows) {
        this.rows = rows;
    }
}
