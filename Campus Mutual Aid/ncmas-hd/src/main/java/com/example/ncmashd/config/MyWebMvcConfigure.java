package com.example.ncmashd.config;



import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class MyWebMvcConfigure implements WebMvcConfigurer {
//    @Autowired
//    private LoginCheckInterceptor loginCheckInterceptor;
    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/static/**").addResourceLocations("file:G:/毕业设计/Campus Mutual Aid/ncmas-hd/src/main/resources/static/img");
        //,"file:static/" 上线路径映射
    }
//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        //注册拦截器
//        registry.addInterceptor(loginCheckInterceptor)
//                .addPathPatterns("/**")             //拦截所有请求
//                .excludePathPatterns("/login","/technician/**","/wechatLogin", "/index", "/userList", "/static/**","/technicianList","/projectList","/userInfoChange","/swagger-ui.html/**");     //要放行的请求
//    }
}