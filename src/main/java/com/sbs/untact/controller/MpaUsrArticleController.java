package com.sbs.untact.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untactTeacher.util.Util;

import lombok.AllArgsConstructor;
import lombok.Data;

import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.ResultData;

@Controller
public class MpaUsrArticleController {
	
	private int i=0;
	
	@RequestMapping("/mpaUsr/article/doWrite")
	@ResponseBody
	public ResultData doWrite(String title, String body) {
		
		int id = i+1;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();
		Article article = new Article(id, regDate, updateDate, title, body);
		i=id;
			
		return new ResultData("S-1", id + "번 글이 작성되었습니다.", "article", article);
	}
	



}
