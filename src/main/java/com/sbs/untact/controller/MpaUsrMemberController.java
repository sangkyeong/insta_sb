package com.sbs.untact.controller;

import java.lang.reflect.Member;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.Service.articleService;
import com.sbs.untact.Service.memberService;
import com.sbs.untact.dto.Board;
import com.sbs.untact.dto.ResultData;
import com.sbs.untact.dto.member;
import com.sbs.untactTeacher.util.Util;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MpaUsrMemberController {
    @Autowired
    private memberService memberService;

    @RequestMapping("/mpaUsr/member/Login")
	public String login(HttpServletRequest req) {
		return "mpaUsr/member/Login";
	}


	@RequestMapping("/mpaUsr/member/dologin")
	public String dologin(HttpSession session, HttpServletRequest req,String loginId, String loginPw, String redirectUrl) {
		if ( Util.isEmpty(redirectUrl) ) {
            redirectUrl = "/";
        }

		member member = memberService.getMemberByLoginId(loginId);

        if (member == null) {
            return Util.msgAndBack(req, loginId + "(은)는 없는 로그인아이디 입니다.");
        }
        
        if (member.getLoginPw().equals(loginPw) == false) {
            return Util.msgAndBack(req, "비밀번호가 일치하지 않습니다.");
        }

        session.setAttribute("loginedMemberId", member.getId());

        String msg = "환영합니다.";
        return Util.msgAndPlace(req, msg, "/");
	}
	
	@RequestMapping("/mpaUsr/member/findLoginPw")
    public String showFindLoginPw(HttpServletRequest req) {
        return "mpaUsr/member/findLoginPw";
    }

    @RequestMapping("/mpaUsr/member/doFindLoginPw")
    public String doFindLoginPw(HttpServletRequest req, String loginId, String name, String email, String redirectUri) {
        if (Util.isEmpty(redirectUri)) {
            redirectUri = "/";
        }

        member Member = memberService.getMemberByLoginId(loginId);

        if (Member == null) {
            return Util.msgAndBack(req, "일치하는 회원이 존재하지 않습니다.");
        }

        if (Member.getName().equals(name) == false) {
            return Util.msgAndBack(req, "일치하는 회원이 존재하지 않습니다.");
        }

        if (Member.getEmail().equals(email) == false) {
            return Util.msgAndBack(req, "일치하는 회원이 존재하지 않습니다.");
        }

        ResultData notifyTempLoginPwByEmailRs = memberService.notifyTempLoginPwByEmail(Member);

        return Util.msgAndPlace(req, notifyTempLoginPwByEmailRs.getMsg(), redirectUri);
    }
	
	@RequestMapping("/mpaUsr/member/dologout")
    public String doLogout(HttpServletRequest req, HttpSession session) {
        session.removeAttribute("loginedMemberId");

        String msg = "로그아웃 되었습니다.";
        return Util.msgAndPlace(req, msg, "/");
    }

    
    
	@RequestMapping("/mpaUsr/member/join")
	public String join(HttpServletRequest req) {
		return "mpaUsr/member/join";
	}


	@RequestMapping("/mpaUsr/member/dojoin")
	public String dojoin(HttpServletRequest req,String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
		member oldMember = memberService.getMemberByLoginId(loginId);

        if (oldMember != null) {
            return Util.msgAndBack(req, loginId + "(은)는 이미 사용중인 로그인아이디 입니다.");
        }

        ResultData joinRd = memberService.dojoin(loginId, loginPw, name, nickname, email, cellphoneNo );

        if (joinRd.isFail()) {
            return Util.msgAndBack(req, joinRd.getMsg());
        }

        return Util.msgAndPlace(req, joinRd.getMsg(), "/");
	}
	
	@RequestMapping("/mpaUsr/member/findLoginId")
    public String showFindLoginId(HttpServletRequest req) {
        return "mpaUsr/member/findLoginId";
    }

    @RequestMapping("/mpaUsr/member/doFindLoginId")
    public String doFindLoginId(HttpServletRequest req, String name, String email, String redirectUri) {
        if (Util.isEmpty(redirectUri)) {
            redirectUri = "/";
        }

        member Member = memberService.getMemberByNameAndEmail(name, email);

        if (Member == null) {
            return Util.msgAndBack(req, "일치하는 회원이 존재하지 않습니다.");
        }

        return Util.msgAndBack(req, String.format("회원님의 아이디는 `%s` 입니다.", Member.getLoginId()));
    }


}
