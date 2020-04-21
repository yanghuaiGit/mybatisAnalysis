package com.example.mybatisexample.configuration;

import com.example.mybatisexample.intercepter.SqlCostInterceptor;
import org.apache.ibatis.plugin.Interceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;

import java.util.Properties;

@Configuration
public class InterceptrConfiguration {
    /**
     * SQL执行效率插件
     */
    @Bean
    public Interceptor performanceInterceptor() {

        Interceptor sqlCostInterceptor = new SqlCostInterceptor();
        Properties properties = new Properties();
        properties.setProperty(SqlCostInterceptor.TIME_LIMIT_KEY, SqlCostInterceptor.DEFAULT_TIME_LIMIT);
        sqlCostInterceptor.setProperties(properties);
        return sqlCostInterceptor;
    }
}
