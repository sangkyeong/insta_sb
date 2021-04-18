package com.sbs.untact.dao;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.Board;


@Mapper
public interface memberDao {
	 
	 void memberJoin(@Param("loginId")int loginId, @Param("loginPw") int loginPw, 
			 @Param("name") String name, @Param("nickname") String nickname
			 ,@Param("email") String email, @Param("cellphoneNo") String cellphoneNo);

	
	 
	 
}
