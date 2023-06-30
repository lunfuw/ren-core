package com.ren.core.utils;

import com.ren.core.exception.BizException;
import lombok.extern.slf4j.Slf4j;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.Collection;

/**
 * <p>
 * 对像校验
 * </p>
 *
 * @author R
 * @version 1.0.0
 * @since 10:53 2019/12/24
 */
@Slf4j
public class VerifyObjectUtil {


    /**
     * 校验 操作数据是否为空，空则抛出异常
     *
     * @param obj 需要操作的数据
     * @throws BizException 数据为空时，抛出：需要操作的数据不存在
     */
    public static <T> T requireNonNull(T obj) {
        if (obj == null) {
            log.debug("参数为空");
            throw new BizException(52000, "参数为空");
        }
        return obj;
    }

    /**
     * 校验 操作数据是否为空，空则抛出异常
     *
     * @param obj 需要操作的数据
     * @throws BizException 数据为空时，抛出：需要操作的数据不存在
     */
    public static <T extends Collection> T requireNonListNull(T obj) {
        if (obj == null || obj.isEmpty()) {
            log.debug("参数为空");
            throw new BizException(52000, "参数为空");
        }
        return obj;
    }

}