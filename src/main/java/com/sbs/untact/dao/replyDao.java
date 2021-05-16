package com.sbs.untact.dao;

import java.lang.reflect.Member;
import java.util.List;
import java.util.Map;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.sbs.untact.dto.Article;
import com.sbs.untact.dto.Board;
import com.sbs.untact.dto.Reply;
import com.sbs.untact.dto.member;

@Mapper
public interface replyDao {

	void write(@Param("relTypeCode") String relTypeCode,
            @Param("relId") int relId,
            @Param("memberId") int memberId,
            @Param("body") String body);

 int getLastInsertId();
 
 List<Reply> getForPrintRepliesByRelTypeCodeAndRelId(
         @Param("relTypeCode") String relTypeCode,
         @Param("relId") int relId);
 
}
