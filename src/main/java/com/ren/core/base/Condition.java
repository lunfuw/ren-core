package com.ren.core.base;

import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;

/**
 * 分页工具
 *
 * @author R
 */
public class Condition {

    /**
     * 转化成mybatis plus中的Page
     *
     * @param query 分页查询条件
     * @return IPage
     */
    public static <T> IPage<T> getPage(Query query) {
        Page<T> page = new Page<>();
        page.setCurrent(query == null || query.getCurrent() == null ? 1 : query.getCurrent());
        page.setSize(query == null || query.getSize() == null ? 1 : query.getSize());
        return page;
    }
}