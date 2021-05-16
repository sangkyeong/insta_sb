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
import com.sbs.untact.dao.replyDao;
import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.Board;
import com.sbs.untact.dto.ResultData;
import com.sbs.untact.dto.member;
import com.sbs.untactTeacher.util.Util;

@Service
public class replyService {

	 @Autowired
	    private replyDao ReplyDao;

	    public ResultData write(String relTypeCode, int relId, int memberId, String body) {
	    	ReplyDao.write(relTypeCode, relId, memberId, body);
	        int id = ReplyDao.getLastInsertId();

	        return new ResultData("S-1", "댓글이 작성되었습니다.", "id", id);
	    }

	
}
