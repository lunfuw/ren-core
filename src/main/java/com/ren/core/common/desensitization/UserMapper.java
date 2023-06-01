package com.ren.core.common.desensitization;


import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

@Mapper
public interface UserMapper extends BaseMapper<User> {
    // 只需要在参数前加上@EncryptTransaction 即可
    long countByEmail(@EncryptTransaction @Param("email") String email);

    long countByMobile(@EncryptTransaction @Param("mobile") String mobile);

}