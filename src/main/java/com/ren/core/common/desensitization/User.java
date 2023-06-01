package com.ren.core.common.desensitization;

import lombok.*;

import java.io.Serializable;
import java.util.Date;

@With
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
@SensitiveData // 插件只对加了该注解的类进行扫描，只有加了这个注解的类才会生效
public class User implements Serializable {
    private Integer id;
    private String username;
    private String openId;
    private String password;
    // 表明对该字段进行加密
    @EncryptTransaction
    private String email;
    // 表明对该字段进行加密
    @EncryptTransaction
    private String mobile;
    private Date createTime;
    private Date expireTime;
    private Boolean status = true;
}