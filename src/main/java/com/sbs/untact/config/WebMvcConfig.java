package com.sbs.untact.config;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

import com.sbs.untact.interceptor.BeforeActionInterceptor;
import com.sbs.untact.interceptor.NeedToLoginInterceptor;
import com.sbs.untact.interceptor.NeedToLogoutInterceptor;

@Configuration
public class WebMvcConfig implements WebMvcConfigurer {
	
	// beforeActionInterceptor 인터셉터 불러오기
    @Autowired
    BeforeActionInterceptor beforeActionInterceptor;
    
    @Autowired
    NeedToLoginInterceptor needToLoginInterceptor;

    @Autowired
    NeedToLogoutInterceptor needToLogoutInterceptor;
    
    // 이 함수는 인터셉터를 적용하는 역할을 합니다.
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // beforeActionInterceptor 인터셉터가 모든 액션 실행전에 실행되도록 처리
        registry.addInterceptor(beforeActionInterceptor)
                .addPathPatterns("/**")
                .excludePathPatterns("/resource/**")
                .excludePathPatterns("/error");

        registry.addInterceptor(needToLoginInterceptor)
                .addPathPatterns("/mpaUsr/article/write")
                .addPathPatterns("/mpaUsr/article/doWrite")
                .addPathPatterns("/mpaUsr/article/doDelete")
                .addPathPatterns("/mpaUsr/article/modify")
                .addPathPatterns("/mpaUsr/article/doModify")
                .addPathPatterns("/mpaUsr/member/modify")
                .addPathPatterns("/mpaUsr/member/doModify")
                .addPathPatterns("/mpaUsr/member/checkPassword")
                .addPathPatterns("/mpaUsr/member/doCheckPassword")
                .addPathPatterns("/mpaUsr/reply/doWrite")
                .addPathPatterns("/mpaUsr/reply/doDelete")
                .addPathPatterns("/mpaUsr/reply/modify")
                .addPathPatterns("/mpaUsr/reply/doModify");

        registry.addInterceptor(needToLogoutInterceptor)
        .addPathPatterns("/mpaUsr/member/findLoginId")
        .addPathPatterns("/mpaUsr/member/doFindLoginId")
        .addPathPatterns("/mpaUsr/member/findLoginPw")
        .addPathPatterns("/mpaUsr/member/doFindLoginPw")
                .addPathPatterns("/mpaUsr/member/login")
                .addPathPatterns("/mpaUsr/member/doLogin")
                .addPathPatterns("/mpaUsr/member/join")
                .addPathPatterns("/mpaUsr/member/doJoin")
                .addPathPatterns("/mpaUsr/member/findLoginId")
                .addPathPatterns("/mpaUsr/member/doFindLoginId")
                .addPathPatterns("/mpaUsr/member/findLoginPw")
                .addPathPatterns("/mpaUsr/member/doFindLoginPw");
    }
}
