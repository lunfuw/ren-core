package com.ren.core.api;

import java.io.Serializable;

/**
 * 返回代码接口
 *
 * @author R
 */
public interface IResultCode extends Serializable {

    /**
     * 获取消息
     *
     * @return message
     */
    String getMessage();

    /**
     * 获取状态码
     *
     * @return code
     */
    int getCode();

}