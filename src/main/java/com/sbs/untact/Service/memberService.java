package com.sbs.untact.Service;

import java.lang.reflect.Member;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
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
	 private MailService mailService;

	 @Value("${custom.siteMainUri}")
	 private String siteMainUri;
	 @Value("${custom.siteName}")
	 private String siteName;
	
	@Autowired
	private memberDao MemberDao;
	
	
	public ResultData dojoin(String loginId, String loginPw, String name, String nickname, String email, String cellphoneNo) {
		loginPw = Util.sha256(loginPw);
		
		MemberDao.memberJoin(loginId, loginPw, name, nickname, email, cellphoneNo);
		return new ResultData("S-1", "가입완료");
	}


	public member getMemberByLoginId(String loginId) {
	
		return MemberDao.getMemberByLoginId(loginId);
	}


	public member getMemberById(int id) {
		return MemberDao.getMemberById(id);
	
	}


	public member getMemberByNameAndEmail(String name, String email) {
		return MemberDao.getMemberByNameAndEmail(name, email);
	}
	public ResultData notifyTempLoginPwByEmail(member actor) {
        String title = "[" + siteName + "] 임시 패스워드 발송";
        String tempPassword = Util.getTempPassword(6);
        String body = "<h1>임시 패스워드 : " + tempPassword + "</h1>";
        body += "<a href=\"" + siteMainUri + "/mpaUsr/member/login\" target=\"_blank\">로그인 하러가기</a>";

        ResultData sendResultData = mailService.send(actor.getEmail(), title, body);

        if (sendResultData.isFail()) {
            return sendResultData;
        }

        setTempPassword(actor, tempPassword);

        return new ResultData("S-1", "계정의 이메일주소로 임시 패스워드가 발송되었습니다.");
    }

    private void setTempPassword(member actor, String tempPassword) {
    	tempPassword = Util.sha256(tempPassword);
        MemberDao.modify(actor.getId(), tempPassword, null, null, null, null);
    }
	
}
