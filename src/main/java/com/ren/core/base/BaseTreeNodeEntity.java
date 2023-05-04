package com.ren.core.base;

import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

/**
 * @author R
 */
@Data
public class BaseTreeNodeEntity<T> implements Serializable {
    @Serial
    private static final long serialVersionUID = 1L;

    @ApiModelProperty(value = "当前节点id")
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long id;

    @ApiModelProperty(value = "父节点id")
    @JsonSerialize(using = ToStringSerializer.class)
    protected Long parentId;

    @ApiModelProperty(value = "子节点")
    List<T> children;

    {
        this.children = new ArrayList<>();
    }

    public void add(T node) {
        this.children.add(node);
    }
}