package com.sbs.untact.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import com.sbs.untact.Service.articleService;
import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.Board;
import com.sbs.untact.dto.ResultData;
import com.sbs.untactTeacher.util.Util;

@Controller
public class MpaUsrArticleController {

	@Autowired
	private articleService ArticleService;

	public MpaUsrArticleController() {

	}

	@RequestMapping("/mpaUsr/article/doWrite")
	@ResponseBody
	public ResultData doWrite(String title, String body) {

		if (Util.isEmpty(title)) {
			return new ResultData("F-2", "제목을 입력해주세요.");
		}

		if (Util.isEmpty(body)) {
			return new ResultData("F-3", "내용을 입력해주세요.");
		}

		return ArticleService.writeArticle(title, body);
	}

	@RequestMapping("/mpaUsr/article/doDelete")
	@ResponseBody
	public String doDelete(HttpServletRequest req, Integer id) {

		if (Util.isEmpty(id)) {
			return msgAndBack(req, "id를 입력해주세요.");
		}

		ResultData rd = ArticleService.deleteArticleById(id);

		if ( rd.isFail() ) {
			return msgAndBack(req, rd.getMsg());
		}

		String redirectUrl = "../article/list?boardId=" + rd.getBody().get("boardId");
		
		return msgAndPlace(req, rd.getMsg(), redirectUrl);
	}

	@RequestMapping("/mpaUsr/article/doModify")
	@ResponseBody
	public ResultData doModify(Integer id, String title, String body) {
		if (Util.isEmpty(id)) {
			return new ResultData("F-1", "번호를 입력해주세요.");
		}

		if (Util.isEmpty(title)) {
			return new ResultData("F-2", "제목을 입력해주세요.");
		}

		if (Util.isEmpty(body)) {
			return new ResultData("F-3", "내용을 입력해주세요.");
		}

		Article article = ArticleService.getArticleById(id);

		if (article == null) {
			return new ResultData("F-4", "존재하지 않는 게시물 번호입니다.");
		}

		return ArticleService.modifyArticle(id, title, body);
	}

	@RequestMapping("/mpaUsr/article/list")
	public String showList(HttpServletRequest req, int boardId) {
		Board board = ArticleService.getBoardById(boardId);
		
		if(board == null) {
			return  msgAndBack(req, boardId + "번 게시판이 존재하지 않습니다.");
		}
		
		req.setAttribute("board", board);
		return "mpaUsr/article/list";

		
	}

	@RequestMapping("/mpaUsr/article/getarticle")
	@ResponseBody
	public ResultData getArticle(Integer id) {

		if (Util.isEmpty(id)) {
			return new ResultData("F-1", "번호를 입력해주세요.");
		}

		Article article = ArticleService.getArticleById(id);

		if (article == null) {

			return new ResultData("F-1", id + "번 글이 없습니다.", "id", id);
		}

		return new ResultData("S-1", id + "번 글입니다.", "article", article);

	}
	
	private String msgAndBack(HttpServletRequest req, String msg) {
		req.setAttribute("msg", msg);
		req.setAttribute("historyBack", true);
		return "common/redirect";
	}
	
	private String msgAndPlace(HttpServletRequest req, String msg, String replaceUrl) {
		req.setAttribute("msg", msg);
		req.setAttribute("replaceUrl", replaceUrl);
		return "common/redirect";
	}

}
