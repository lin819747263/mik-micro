package com.mik.db.config;

import com.baomidou.mybatisplus.core.handlers.MetaObjectHandler;
import com.baomidou.mybatisplus.extension.plugins.PaginationInterceptor;
import com.mik.db.properties.MybatisPlusAutoFillProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnMissingBean;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.EnableAspectJAutoProxy;

@EnableConfigurationProperties(MybatisPlusAutoFillProperties.class)
@EnableAspectJAutoProxy
public class MybatisPlusAutoConfigure {

    @Autowired
    private MybatisPlusAutoFillProperties autoFillProperties;

    @Bean
    @ConditionalOnMissingBean
    @ConditionalOnProperty(prefix = "linmsen.mybatis-plus.auto-fill", name = "enabled", havingValue = "true", matchIfMissing = true)
    public MetaObjectHandler metaObjectHandler() {
        return new DateObjectHandler(autoFillProperties);
    }


    /**
     * 分页插件，自动识别数据库类型
     */
    @Bean
    public PaginationInterceptor paginationInterceptor() {
        PaginationInterceptor paginationInterceptor = new PaginationInterceptor();
        return paginationInterceptor;
    }
}
