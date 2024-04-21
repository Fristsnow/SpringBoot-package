package org.lucky.kfirstsnowluckyadmin.config;

import org.lucky.kfirstsnowluckyadmin.interceptions.LoginInterceptions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class WebConfig implements WebMvcConfigurer {

    @Autowired
    private LoginInterceptions loginInterceptions;

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(loginInterceptions)
//                .excludePathPatterns("/login", "/register");
//    }
}
