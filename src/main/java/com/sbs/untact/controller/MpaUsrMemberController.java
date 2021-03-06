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
import com.sbs.untact.dto.Rq;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MpaUsrMemberController {
    @Autowired
    private memberService memberService;
    
    @RequestMapping("/mpaUsr/member/mypage")
    public String showMypage(HttpServletRequest req) {
        return "mpaUsr/member/mypage";
    }

    @RequestMapping("/mpaUsr/member/modify")
    public String showModify(HttpServletRequest req) {
        return "mpaUsr/member/modify";
    }

    @RequestMapping("/mpaUsr/member/doModify")
    public String doModify(HttpSession session,HttpServletRequest req, String loginPw, String name, String
            nickname, String cellphoneNo, String email) {

        if ( loginPw != null && loginPw.trim().length() == 0 ) {
            loginPw = null;
        }

        int id = ((Rq)req.getAttribute("rq")).getLoginedMemberId();
        ResultData modifyRd = memberService.modify(id, loginPw, name, nickname, cellphoneNo, email);

        if (modifyRd.isFail()) {
            return Util.msgAndBack(req, modifyRd.getMsg());
        }
        

        return Util.msgAndPlace(req, modifyRd.getMsg(), "/");
    }
    
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
    public String doFindLoginPw(HttpServletRequest req, String loginId, String name, String email, String redirectUrl) {
        if (Util.isEmpty(redirectUrl)) {
            redirectUrl = "/";
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

        return Util.msgAndPlace(req, notifyTempLoginPwByEmailRs.getMsg(), redirectUrl);
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
		member Member = memberService.getMemberByNameAndEmail(name, email);
		
        if (oldMember != null) {
            return Util.msgAndBack(req, loginId + "(은)는 이미 사용중인 로그인아이디 입니다.");
        }

        if (Member != null) {
            return Util.msgAndBack(req, "이미 존재하는 회원입니다.");
        }

        ResultData joinRd = memberService.dojoin(loginId, loginPw, name, nickname, email, cellphoneNo );

        if (joinRd.isFail()) {
            return Util.msgAndBack(req, joinRd.getMsg());
        }

        return Util.msgAndPlace(req, joinRd.getMsg(), "/");
	}
	
	@RequestMapping("/mpaUsr/member/checkPassword")
    public String showCheckPassword(HttpServletRequest req) {
        return "mpaUsr/member/checkPassword";
    }

    @RequestMapping("/mpaUsr/member/doCheckPassword")
    public String doCheckPassword(HttpSession session, HttpServletRequest req, String loginPw, String redirectUrl) {
        member loginedMember = ((Rq) req.getAttribute("rq")).getLoginedMember();

        if (loginedMember.getLoginPw().equals(loginPw) == false) {
            return Util.msgAndBack(req, "비밀번호가 일치하지 않습니다.");
        }
        
        session.setAttribute("checkpasswordPw", loginedMember.getLoginPw());
        

        return Util.msgAndPlace(session, req, "", redirectUrl);
    }
	
	@RequestMapping("/mpaUsr/member/findLoginId")
    public String showFindLoginId(HttpServletRequest req) {
        return "mpaUsr/member/findLoginId";
    }

    @RequestMapping("/mpaUsr/member/doFindLoginId")
    public String doFindLoginId(HttpServletRequest req, String name, String email, String redirectUrl) {
        if (Util.isEmpty(redirectUrl)) {
            redirectUrl = "/";
        }

        member Member = memberService.getMemberByNameAndEmail(name, email);

        if (Member == null) {
            return Util.msgAndBack(req, "일치하는 회원이 존재하지 않습니다.");
        }

        return Util.msgAndBack(req, String.format("회원님의 아이디는 `%s` 입니다.", Member.getLoginId()));
    }


}
