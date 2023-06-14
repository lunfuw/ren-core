package com.ren.core.base;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.ren.core.constant.RenConstant;
import com.ren.core.handler.AuthContextHandler;
import lombok.SneakyThrows;
import org.springframework.validation.annotation.Validated;

import java.time.LocalDateTime;
import java.util.Collection;
import java.util.List;

/**
 * 业务封装基础类
 *
 * @param <M> mapper
 * @param <T> model
 * @author R
 */
@Validated
public class BaseServiceImpl<M extends BaseMapper<T>, T extends BaseEntity>
        extends ServiceImpl<M, T>
        implements BaseService<T> {

    @Override
    public boolean save(T entity) {
        this.resolveEntity(entity);
        return super.save(entity);
    }

    @Override
    public boolean saveBatch(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::resolveEntity);
        return super.saveBatch(entityList, batchSize);
    }

    @Override
    public boolean updateById(T entity) {
        this.resolveEntity(entity);
        return super.updateById(entity);
    }

    @Override
    public boolean updateBatchById(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::resolveEntity);
        return super.updateBatchById(entityList, batchSize);
    }


    @Override
    public boolean saveOrUpdateBatch(Collection<T> entityList, int batchSize) {
        entityList.forEach(this::resolveEntity);
        return super.saveOrUpdateBatch(entityList, batchSize);
    }


    @SneakyThrows
    protected void resolveEntity(T entity) {
        if (entity == null) {
            return;
        }
        Long userId = null;
        try {
            userId = AuthContextHandler.getUserId();
        } catch (Exception e) {
            e.printStackTrace();
            userId = -1L;
        }
        LocalDateTime now = LocalDateTime.now();
        if (entity.getId() == null) {
            // 创建
            if (userId == null) {
                userId = 1L;
            } else if (userId <= 0) {
                userId = 1L;
            }
            entity.setCreateUser(userId);
            entity.setUpdateUser(userId);
        } else if (userId > 0) {
            // 更新
            entity.setUpdateUser(userId);
        }
        if (entity.getStatus() == null) {
            entity.setStatus(RenConstant.DB_STATUS_NORMAL);
        }
        if (entity.getCreateTime() == null) {
            entity.setCreateTime(now);
        }
        entity.setUpdateTime(now);
        if (entity.getIsDeleted() == null) {
            entity.setIsDeleted(RenConstant.DB_NOT_DELETED);
        }
    }

    @Override
    public boolean deleteLogic(List<Long> ids) {
        return this.baseMapper.deleteBatchIds(ids) == 1;
    }

    @Override
    public boolean changeStatus(List<Long> ids, Integer status) {
        return false;
    }
}