package com.ren.core.config;

import com.ren.core.utils.SpringUtil;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.Ordered;
import org.springframework.core.annotation.Order;

/**
 * @author R
 */
@Configuration
@Order(Ordered.HIGHEST_PRECEDENCE)
@EnableConfigurationProperties(RenProperties.class)
public class AutoConfiguration {

    @Bean
    public SpringUtil springUtil(){
        return new SpringUtil();
    }


}