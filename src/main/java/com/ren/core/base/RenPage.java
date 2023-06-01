package com.ren.core.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.fasterxml.jackson.annotation.JsonView;

import java.util.Collections;
import java.util.List;

/**
 * @author R
 */
public class RenPage<T> {
    /**
     * 查询数据列表
     */
    @JsonView(Common.class)
    private List<T> records = Collections.emptyList();

    /**
     * 总数
     */
    @JsonView(Common.class)
    private long total;

    /**
     * 每页显示条数，默认 10
     */
    @JsonView(Common.class)
    private long size;
    /**
     * 当前页
     */
    @JsonView(Common.class)
    private long current;
    @JsonView(Common.class)
    private long pages;

    public RenPage() {
    }

    public RenPage(long current, long size, List<T> records) {
        this.current = current;
        this.size = size;
        this.total = 0;
        this.pages = 0;
        this.records = records;
    }

    public RenPage(long current, long size, long total, long pages, List<T> records) {
        this.current = current;
        this.size = size;
        this.total = total;
        this.pages = pages;
        this.records = records;
    }

    public RenPage(IPage<T> iPage, List<T> records) {
        this.current = iPage.getCurrent();
        this.size = iPage.getSize();
        this.total = iPage.getTotal();
        this.pages = iPage.getPages();
        this.records = records;
    }

}