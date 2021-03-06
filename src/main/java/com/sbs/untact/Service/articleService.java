package com.sbs.untact.Service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sbs.untact.dao.articleDao;
import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.Board;
import com.sbs.untact.dto.ResultData;
import com.sbs.untactTeacher.util.Util;

@Service
public class articleService {

	@Autowired
	private articleDao ArticleDao;
	

	public ResultData modifyArticle(int id, String title, String body) {
		Article article = getArticleById(id);

		if (isEmpty(article)) {
			return new ResultData("F-1", "존재하지 않는 게시물 번호입니다.", "id", id);
		}

		ArticleDao.modifyArticle(id, title, body);

		return new ResultData("S-1", "게시물이 수정되었습니다.", "id", id);
	}
	
	private boolean isEmpty(Article article) {
		if (article == null) {
			return true;
		} else if (article.isDelStatus()) {
			return true;
		}

		return false;
	}

	public ResultData deleteArticleById(int id) {
		Article article = getArticleById(id);

		if (isEmpty(article)) {
			return new ResultData("F-1", "게시물이 존재하지 않습니다.", "id", id,  "boardId", article.getBoardId());
		}

		ArticleDao.deleteArticleById(id);
		
		return new ResultData("S-1", id + "번 게시물이 삭제되었습니다.", "id", id);
	}

	public ResultData writeArticle(int boardId, int memberId, String title, String body) {
		
		ArticleDao.writeArticle(boardId, memberId, title, body);
		int id = ArticleDao.getLastInsertId();

		return new ResultData("S-1", "게시물이 작성되었습니다.", "id", id);
	}

	public Article getArticleById(int id) {
		
		return ArticleDao.getArticleById(id);
	}
	
	public Board getBoardById(int id) {
		return ArticleDao.getBoardById(id);
	}

	public int getArticlesTotalCount(int boardId,String searchKeywordType, String searchKeyword) {
		
		return ArticleDao.getArticlesTotalCount(boardId,searchKeywordType, searchKeyword);
	}

	public List<Article> getForPrintArticles(int boardId,String searchKeywordType, String searchKeyword, int itemsCountInAPage, int page) {
		int limitFrom = (page - 1) * itemsCountInAPage;
		int limitTake = itemsCountInAPage;

		return ArticleDao.getForPrintArticles(boardId, searchKeywordType, searchKeyword, limitFrom, limitTake);
	
	}
	
	public Article getForPrintArticleById(int id) {
		return ArticleDao.getForPrintArticleById(id);
	}
	
	
}
