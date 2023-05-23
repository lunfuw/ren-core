package com.ren.core.base;

import com.baomidou.mybatisplus.extension.service.IService;

import java.util.List;

/**
 * 基础业务接口
 *
 * @param <T>
 * @author R
 */
public interface BaseService<T> extends IService<T> {

	/**
	 * 逻辑删除
	 *
	 * @param ids id集合
	 * @return boolean
	 */
	boolean deleteLogic(List<Long> ids);

	/**
	 * 变更状态
	 *
	 * @param ids    id集合
	 * @param status 状态值
	 * @return boolean
	 */
	boolean changeStatus(List<Long> ids, Integer status);

}