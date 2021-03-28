package com.sbs.untact.dto;

import com.sbs.untact.controller.MpaUsrArticleController;

import lombok.AllArgsConstructor;
import lombok.Data;

@AllArgsConstructor
@Data
public class Article {

	// getter와 setter를 알아서 해줌

	private int id;
	private String regDate;
	private String updateDate;
	private String title;
	private String body;

}
