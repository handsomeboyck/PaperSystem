package com.ccnu.paper_service.config;


import com.ccnu.paper_service.interceptor.CorsInterceptor;
import com.ccnu.paper_service.interceptor.LoginInterceptor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/**
 * @Author: ck
 * @Description: 登陆之后才可访问的路径 /api/v1/pri/
 *     不需要登陆也可访问的路径 /api/v1/pub
 * @Date: Create in 18:14 2020/7/8
 */
@Configuration
public class InterceptorConfig implements WebMvcConfigurer {
    @Bean
    LoginInterceptor loginInterceptor()
    {
        return new LoginInterceptor();
    }
    @Bean
    CorsInterceptor corsInterceptor(){
        return new CorsInterceptor();
    }

    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        //跨域配置 拦截全部接口
        registry.addInterceptor(corsInterceptor()).addPathPatterns("/**");

        registry.addInterceptor(loginInterceptor()).addPathPatterns("/api/v1/pri/*/*/**")
                //不拦截哪些路径   斜杠一定要加
                .excludePathPatterns("/api/v1/pri/lawyer/login","/api/v1/pri/lawyer/register","/api/v1/pri/defendant_one/saveOneDefendant","/api/v1/pub/defendant_one/zip");
        WebMvcConfigurer.super.addInterceptors(registry);

    }
}
