package com.sbs.untact.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.untact.dao.articleDao;
import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.ResultData;
import com.sbs.untactTeacher.util.Util;

@Service
public class articleService {

	@Autowired
	private articleDao ArticleDao;
	

	public ResultData modifyArticle(int id, String title, String body) {
		Article article = getArticleById(id);

		if (article == null) {
			return new ResultData("F-1", "존재하지 않는 게시물 번호입니다.", "id", id);
		}

		ArticleDao.modifyArticle(id, title, body);

		return new ResultData("S-1", "게시물이 수정되었습니다.", "id", id);
	}

	public ResultData deleteArticleById(int id) {
		Article article = getArticleById(id);

		if (article == null) {
			return new ResultData("F-1", "게시물이 존재하지 않습니다.", "id", id);
		}

		ArticleDao.deleteArticleById(id);
		
		return new ResultData("S-1", id + "번 게시물이 삭제되었습니다.", "id", id);
	}

	public ResultData writeArticle(String title, String body) {
		int id = ArticleDao.writeArticle(title, body);

		return new ResultData("S-1", "게시물이 작성되었습니다.", "id", id);
	}

	public Article getArticleById(int id) {
		
		return ArticleDao.getArticleById(id);
	}
}
