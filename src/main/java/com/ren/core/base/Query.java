package com.ren.core.base;

import io.swagger.annotations.ApiModel;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.experimental.Accessors;

/**
 * 分页工具
 *
 * @author R
 */
@Data
@Accessors(chain = true)
@ApiModel(description = "查询条件")
public class Query {

    /**
     * 当前页
     */
    @ApiModelProperty(value = "当前页")
    private Integer current = 1;

    /**
     * 每页的数量
     */
    @ApiModelProperty(value = "每页的数量")
    private Integer size = 10;

    /**
     * 正排序规则
     */
    @ApiModelProperty(hidden = true)
    private String asc;

    /**
     * 倒排序规则
     */
    @ApiModelProperty(hidden = true)
    private String desc;

    public Query setCurrent(final Integer current) {
        this.current = current;
        return this;
    }

    public Query setSize(final Integer size) {
        this.size = size;
        return this;
    }

    public Query setAsc(final String asc) {
        this.asc = asc;
        return this;
    }

    public Query setDesc(final String desc) {
        this.desc = desc;
        return this;
    }

}