package com.ren.core.base;

import com.ren.core.api.Result;
import org.springframework.beans.factory.annotation.Autowired;

import jakarta.servlet.http.HttpServletRequest;

/**
 * Base控制器封装类
 *
 * @author R
 */
public class BaseController<M extends BaseService<T>, T extends BaseEntity> {
    @Autowired
    protected M baseService;

    @Autowired
    private HttpServletRequest request;

    /**
     * 获取request
     */
    public HttpServletRequest getRequest() {
        return this.request;
    }


    /**
     * 返回ApiResult
     *
     * @param data 数据
     * @return Result
     */
    public <T> Result<T> data(T data) {
        return Result.data(data);
    }

    /**
     * 返回ApiResult
     *
     * @param data    数据
     * @param message 消息
     * @return Result
     */
    public <T> Result<T> data(T data, String message) {
        return Result.data(data, message);
    }

    /**
     * 返回ApiResult
     *
     * @param data    数据
     * @param message 消息
     * @param code    响应码
     * @return Result
     */
    public <T> Result<T> data(T data, String message, int code) {
        return Result.data(code, data, message);
    }

    /**
     * 返回ApiResult
     *
     * @param message 消息
     * @return Result
     */
    public Result success(String message) {
        return Result.success(message);
    }

    /**
     * 返回ApiResult
     *
     * @param message 消息
     * @return Result
     */
    public Result fail(String message) {
        return Result.fail(message);
    }

    /**
     * 返回ApiResult
     *
     * @param flag 状态
     * @return Result
     */
    public Result status(boolean flag) {
        return Result.status(flag);
    }

}