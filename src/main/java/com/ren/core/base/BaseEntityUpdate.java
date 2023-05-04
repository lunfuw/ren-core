package com.ren.core.base;


import com.fasterxml.jackson.databind.annotation.JsonSerialize;
import com.fasterxml.jackson.databind.ser.std.ToStringSerializer;
import io.swagger.annotations.ApiModelProperty;
import lombok.Data;

import java.io.Serializable;

/**
 * 基础实体类
 *
 * @author R
 */
@Data
public class BaseEntityUpdate implements Serializable {
    /**
     * 主键id
     */
    @JsonSerialize(using = ToStringSerializer.class)
    @ApiModelProperty(value = "id", required = true)
    private Long id;
}