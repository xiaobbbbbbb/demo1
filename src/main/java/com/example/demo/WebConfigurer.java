package com.example.demo;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;

/**
 * Created by niko on 2019/8/5.
 */
@Configuration
public class WebConfigurer implements WebMvcConfigurer {

    /**
     * 放到springcontext管理 先初始化 @Autowired为null
     * @return
     */
    @Bean
    public FangShuaInterceptor getFangShuaInterceptor() {
        return new FangShuaInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        registry.addInterceptor(getFangShuaInterceptor()).addPathPatterns("/**");

    }
//


}
