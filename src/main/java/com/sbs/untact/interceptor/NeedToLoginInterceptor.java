package com.sbs.untact.interceptor;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

import com.sbs.untact.dto.Rq;
import com.sbs.untactTeacher.util.Util;

import lombok.extern.slf4j.Slf4j;

@Component
@Slf4j
public class NeedToLoginInterceptor implements HandlerInterceptor{

	
	@Override
    public boolean preHandle(HttpServletRequest req, HttpServletResponse resp, Object handler) throws Exception {
        Rq rq = (Rq) req.getAttribute("rq");

        if (rq.isNotLogined()) {
            resp.setContentType("text/html; charset=UTF-8");
            String afterLoginUrl = rq.getEncodedCurrentUrl();
            resp.getWriter().append(Util.msgAndReplace("로그인 후 이용해주세요.", "../member/Login?afterLoginUrl=" + afterLoginUrl));
            
            return false;
        }

        return HandlerInterceptor.super.preHandle(req, resp, handler);
    }
}
