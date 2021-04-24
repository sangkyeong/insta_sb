package com.sbs.untact.controller;

import java.lang.reflect.Member;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.Service.articleService;
import com.sbs.untact.Service.memberService;
import com.sbs.untact.dto.Board;
import com.sbs.untact.dto.ResultData;
import com.sbs.untactTeacher.util.Util;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MpaUsrMemberController {
    @Autowired
    private memberService memberService;

	
	@RequestMapping("/mpaUsr/member/join")
	public String join(HttpServletRequest req) {
		return "mpaUsr/member/join";
	}


	@RequestMapping("/mpaUsr/member/dojoin")
	public String dojoin(HttpServletRequest req,String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
		Member oldMember = memberService.getMemberByLoginId(loginId);

        if (oldMember != null) {
            return Util.msgAndBack(req, loginId + "(은)는 이미 사용중인 로그인아이디 입니다.");
        }

        ResultData joinRd = memberService.dojoin(loginId, loginPw, name, nickname, email, cellphoneNo );

        if (joinRd.isFail()) {
            return Util.msgAndBack(req, joinRd.getMsg());
        }

        return Util.msgAndPlace(req, joinRd.getMsg(), "/");
	}


}
