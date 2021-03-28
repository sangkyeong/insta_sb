package com.sbs.untact.controller;

import java.util.ArrayList;
import java.util.List;

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

	private int i;
	private List<Article> articles;
	
	public MpaUsrArticleController() {
		articles = new ArrayList<>();
		i = 0;
	}

	@RequestMapping("/mpaUsr/article/doWrite")
	@ResponseBody
	public ResultData doWrite(String title, String body) {

		int id = WriteArticle(title, body);
		Article article = getArticleById(id);

		return new ResultData("S-1", id + "번 글이 작성되었습니다.", "article", article);
	}
	
	
	@RequestMapping("/mpaUsr/article/doDelete")
	@ResponseBody
	public ResultData doDelete(int id) {
		boolean deleted = deleteArticleById(id);
		
		if(deleted==false) {
			return new ResultData("S-1", id + "번 글이 없습니다.", "id", id);
		}
		
		
		return new ResultData("S-1", id + "번 글이 삭제되었습니다.", "id", id);
	}
	
	
	private boolean deleteArticleById(int id) {
		
		for (Article article : articles) {
			if (article.getId() == id) {
				articles.remove(article);
				return true;
			}

		}
		
		
		return false;
	}

	public int WriteArticle(String title, String body) {
		int id = i + 1;
		String regDate = Util.getNowDateStr();
		String updateDate = Util.getNowDateStr();
		Article article = new Article(id, regDate, updateDate, title, body);
		articles.add(article);
		i = id;
		
		return id;
	}

	@RequestMapping("/mpaUsr/article/getarticle")
	@ResponseBody
	public ResultData getArticle(int id) {
		Article article = getArticleById(id);
		
		if(article==null) {
			
			return new ResultData("F-1", id + "번 글이 없습니다.", "id", id);
		}

		return new ResultData("S-1", id + "번 글입니다.", "article", article);

	}

	private Article getArticleById(int id) {

		for (Article article : articles) {
			if (article.getId() == id) {
				return article;

			}

		}
		return null;
	}

}
