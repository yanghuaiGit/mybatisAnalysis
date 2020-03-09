package com.example.mybatisexample.configuration.mybatis.handler;

import org.apache.ibatis.session.Configuration;
import org.mybatis.spring.boot.autoconfigure.ConfigurationCustomizer;

/**
 * @author huaiyang
 * @version 1.0.0
 * @date 2019/10/20
 * @description
 * @copyright 本内容仅限于深圳市天行云供应链有限公司内部传阅，禁止外泄以及用于其他的商业目的
 */

//@Component
public class CustomConfigurationCustomizer implements ConfigurationCustomizer {
    @Override
    public void customize(Configuration configuration) {
        // 直接在 CustomTypeHandler 进行@Component 就可以了
        configuration.getTypeHandlerRegistry().register(new CustomTypeHandler());
    }
}
