package com.sbs.untact.dao;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.Board;
import com.sbs.untact.dto.member;

@Mapper
public interface memberDao {

	void memberJoin(@Param("loginId") String loginId, @Param("loginPw") String loginPw, @Param("name") String name,
			@Param("nickname") String nickname, @Param("email") String email, @Param("cellphoneNo") String cellphoneNo);

	member getMemberByLoginId(@Param("loginId") String loginId);

	member getMemberById(@Param("id") int id);

	int getLastInsertId();

	member getMemberByNameAndEmail(@Param("name") String name, @Param("email") String email);
	
	void modify(@Param("id") int id, @Param("loginPw") String loginPw, @Param("name") String name, @Param("nickname") String nickname, @Param("cellphoneNo") String cellphoneNo, @Param("email") String email);
}
