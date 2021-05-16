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
import com.sbs.untact.Service.replyService;
import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.Board;
import com.sbs.untact.dto.ResultData;
import com.sbs.untact.dto.member;
import com.sbs.untactTeacher.util.Util;
import com.sbs.untact.dto.Rq;

import lombok.extern.slf4j.Slf4j;

@Controller
@Slf4j
public class MpaUsrReplyController {
	   @Autowired
	    private articleService articleService;
	    @Autowired
	    private replyService ReplyService;

	    @RequestMapping("/mpaUsr/reply/doWrite")
	    public String showWrite(HttpServletRequest req, String relTypeCode, int relId, String body, String redirectUri) {
	        switch ( relTypeCode ) {
	            case "article":
	                Article article = articleService.getArticleById(relId);
	                if ( article == null ) {
	                    return Util.msgAndBack(req, "해당 게시물이 존재하지 않습니다.");
	                }
	                break;
	            default:
	                return Util.msgAndBack(req, "올바르지 않은 relTypeCode 입니다.");
	        }

	        Rq rq = (Rq)req.getAttribute("rq");

	        int memberId = rq.getLoginedMemberId();

	        ResultData writeResultData = ReplyService.write(relTypeCode, relId, memberId, body);

	        return Util.msgAndPlace(req, writeResultData.getMsg(), redirectUri);
	    }


}
