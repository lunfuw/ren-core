package com.ren.core.constant;

/**
 * 系统常量
 *
 * @author R
 */
public interface RenConstant {

    /**
     * 编码
     */
    String UTF_8 = "UTF-8";

    /**
     * contentType
     */
    String CONTENT_TYPE_NAME = "Content-type";

    /**
     * JSON 资源
     */
    String CONTENT_TYPE = "application/json;charset=utf-8";

    /**
     * 默认为空消息
     */
    String DEFAULT_NULL_MESSAGE = "暂无承载数据";
    /**
     * 默认成功消息
     */
    String DEFAULT_SUCCESS_MESSAGE = "操作成功";
    /**
     * 默认失败消息
     */
    String DEFAULT_FAILURE_MESSAGE = "操作失败";
    /**
     * 默认未授权消息
     */
    String DEFAULT_UNAUTHORIZED_MESSAGE = "签名认证失败";

    String DEV_CODE = "dev";
    String TEST_CODE = "test";
    String PROD_CODE = "prod";
    String APPLICATION_VERSION = "1.0.0";
    String OS_NAME_LINUX = "LINUX";
    /**
     * 业务状态[1:正常]
     */
    int DB_STATUS_NORMAL = 1;
    /**
     * 删除状态[0:正常,1:删除]
     */
    int DB_NOT_DELETED = 0;
    int CHINESE_CHARACTER_128 = 128;
    String LOG_NORMAL_TYPE = "日志";
    String EVENT_LOG = "日志";
    /**
     * grant_type password
     */
    String GRANT_TYPE_HEADER_KEY_PASSWORD = "password";

    /**
     * grant_type captcha
     */
    String GRANT_TYPE_HEADER_KEY_CAPTCHA = "captcha";

    /**
     * 业务系统使用 验证方式
     * grant_type business
     */
    String GRANT_TYPE_HEADER_KEY_BLOG = "blog";

}