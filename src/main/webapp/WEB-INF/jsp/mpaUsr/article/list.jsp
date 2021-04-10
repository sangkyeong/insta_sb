<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pagetitle" value="<span><i class='far fa-clipboard'></i></span> <span>${board.name} 게시물 리스트 </span>"/>

<%@ include file="../common/header.jspf" %>

<div class="section section-article-list">
	<div class="container mx-auto">
		<span>TOTAL ITEMS : </span>
		<span>${totalItemsCount}</span>
	</div>
</div>
<%@ include file="../common/footer.jspf" %>
