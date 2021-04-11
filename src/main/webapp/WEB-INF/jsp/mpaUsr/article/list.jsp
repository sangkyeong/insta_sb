<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<c:set var="pagetitle" value="<span><i class='far fa-clipboard'></i></span> <span>${board.name} 게시물 리스트 </span>"/>

<%@ include file="../common/header.jspf" %>

		<div class="total-items">
			<span>TOTAL ITEMS : </span>
			<span>${totalItemsCount}</span>
		</div>

		<div class="total-pages">
			<span>TOTAL PAGES : </span>
			<span>${totalPage}</span>
		</div>

		<div class="page">
			<span>CURRENT PAGE : </span>
			<span>${page}</span>
		</div>

		<hr />
		<hr />
	<c:if test="${articles == null || articles.size() == 0}">
				검색결과가 존재하지 않습니다.
			</c:if>
		<div class="articles">
			<c:forEach items="${articles}" var="article">
				<div>
					ID : ${article.id}<br>
					REG DATE : ${article.regDate}<br>
					UPDATE DATE : ${article.updateDate}<br>
					TITLE : ${article.title}<br>
					
					
				</div>
				<hr />
			</c:forEach>
			
			

		</div>
		
		<div class="pages">
		<c:set var="pageMenuArmSize" value="4"	/>
			<c:set var="startPage" value="${page - pageMenuArmSize >= 1 ? page - pageMenuArmSize : 1}"	/>
			<c:set var="endPage" value="${page + pageMenuArmSize <= totalPage ? page + pageMenuArmSize : totalPage}"	/>
			
			<c:set var="url" value="?boardId=${board.id}" />
				<c:set var="url" value="${url}&searchKeywordType=${param.searchKeywordType}" />
				<c:set var="url" value="${url}&searchKeyword=${param.searchKeyword}" />
				
			<c:if test="${startPage > 1}">
			<a class="text-lg" href="${url}&page=1">◀◀</a>
			<a class="text-lg" href="${url}&page=${startPage - 1}">◀</a>
			</c:if>
			<c:forEach var="i" begin="${startPage}" end="${endPage}">

				
				<a class="text-lg ${page == i ? 'text-red-500' : ''}" href="${url}&page=${i}">${i}</a>
				
				
			</c:forEach>
			

			
			<c:if test="${endPage < totalPage}">
			<a class="text-lg" href="${url}&page=${endPage + 1}">▶</a>
			<a class="text-lg" href="${url}&page=${totalPage}">▶▶</a>
			
			</c:if>
			
			
			
			
		</div>
		

	



<%@ include file="../common/footer.jspf" %>
