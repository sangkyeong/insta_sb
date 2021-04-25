package com.sbs.untact.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.untact.dao.articleDao;
import com.sbs.untact.dao.memberDao;
import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.Board;
import com.sbs.untact.dto.ResultData;
import com.sbs.untact.dto.member;
import com.sbs.untactTeacher.util.Util;

@Service
public class memberService {

	@Autowired
	private memberDao MemberDao;
	
	
	public ResultData dojoin(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
		MemberDao.memberJoin(loginId, loginPw, name, nickname, email, cellphoneNo);
		return new ResultData("S-1", "가입완료");
	}


	public member getMemberByLoginId(String loginId) {
	
		return MemberDao.getMemberByLoginId(loginId);
	}


	public member getMemberById(int id) {
		return MemberDao.getMemberById(id);
	
	}
	
	
}
