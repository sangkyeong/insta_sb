package com.sbs.untact.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.Service.articleService;
import com.sbs.untact.dto.Board;
import com.sbs.untactTeacher.util.Util;

@Controller
public class MpaUsrMemberController {

	@Autowired
	private articleService ArticleService;

	public MpaUsrMemberController() {

	}


	@RequestMapping("/mpaUsr/member/join")
	@ResponseBody
	public String join(HttpServletRequest req, String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
		//Board board = ArticleService.getBoardById(boardId);

		if (Util.isEmpty(loginId)) {
			return Util.msgAndBack(req, "아이디를 입력해주세요.");
		}

		if (Util.isEmpty(loginPw)) {
			return Util.msgAndBack(req, "비밀번호를 입력해주세요.");
		}
		
		if (Util.isEmpty(name)) {
			return Util.msgAndBack(req, "이름을 입력해주세요.");
		}
		
		if (Util.isEmpty(nickname)) {
			return Util.msgAndBack(req, "닉네임을 입력해주세요.");
		}
		
		if (Util.isEmpty(email)) {
			return Util.msgAndBack(req, "이메일을 입력해주세요.");
		}
		
		if (Util.isEmpty(cellphoneNo)) {
			return Util.msgAndBack(req, "휴대폰번호를 입력해주세요.");
		}
		
		Util.mapOf(loginId, loginPw, name, nickname, email, cellphoneNo);
		
		/*
		if (board == null) {
			return Util.msgAndBack(req, boardId + "번 게시판이 존재하지 않습니다.");
		}*/

		//req.setAttribute("board", board);

		return "mpaUsr/member/join";
	}


}
